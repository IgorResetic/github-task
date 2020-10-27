package com.example.githubtask.ui.search

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.githubtask.models.domain.GitHubRepo
import com.example.githubtask.repository.SearchRepository
import com.example.githubtask.util.DataState
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

@ExperimentalCoroutinesApi
class SearchViewModel
@ViewModelInject
constructor(
    private val searchRepository: SearchRepository
) : ViewModel() {

    companion object {
        const val ORDER_BY_STARS = "Stars"
        const val ORDER_BY_FORKS = "Forks"
        const val ORDER_BY_UPDATE_AT = "Update"
    }

    private lateinit var repIds: List<Int>
    private lateinit var query: String

    private val _dataState: MutableLiveData<DataState<List<GitHubRepo>>> = MutableLiveData()

    val dataState: LiveData<DataState<List<GitHubRepo>>>
        get() = _dataState

    fun setStateEvent(mainStateEvent: MainStateEvent, orderBy: String = "") {
        viewModelScope.launch {
            when (mainStateEvent) {
                is MainStateEvent.GetReposEvent -> {
                    searchRepository.searchGitHub(query)
                        .onEach {dataState ->
                            _dataState.value = dataState
                        }
                        .launchIn(viewModelScope)
                }
                is MainStateEvent.GetOrderReposEvent -> {
                    searchRepository.orderGitHubRepos(query, orderBy)
                        .onEach {dataState ->
                            _dataState.value = dataState
                        }
                        .launchIn(viewModelScope)
                }
                MainStateEvent.None -> {
                    // who cares
                }
            }
        }
    }

    public fun setRepoIds(ids: List<Int>){
        repIds = ids
    }

    public fun setQuery(searchQuery: String) {
        query = searchQuery
    }
}

sealed class MainStateEvent {

    object GetReposEvent : MainStateEvent()

    object GetOrderReposEvent : MainStateEvent()

    object None : MainStateEvent()
}
