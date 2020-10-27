package com.example.githubtask.ui.repositorydetail

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.githubtask.models.domain.GitHubRepo
import com.example.githubtask.models.domain.User
import com.example.githubtask.repository.RepoRepository
import com.example.githubtask.util.DataState
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

@ExperimentalCoroutinesApi
class RepositoryDetailViewModel
@ViewModelInject
constructor(
    private val repoRepository: RepoRepository
) : ViewModel() {

    private val _dataState: MutableLiveData<DataState<GitHubRepo>> = MutableLiveData()

    val dataState: LiveData<DataState<GitHubRepo>>
        get() = _dataState

    private val _repo = MutableLiveData<GitHubRepo>()

    val repo: LiveData<GitHubRepo>
        get() = _repo

    fun setStateEvent(repoStateEvent: RepoStateEvent, owner: String, name: String) {
        viewModelScope.launch {
            when (repoStateEvent) {
                is RepoStateEvent.GetRepoEvent -> {
                    repoRepository.getGitHubRepo(owner, name)
                        .onEach {dataState ->
                            _dataState.value = dataState
                        }
                        .launchIn(viewModelScope)
                }

                RepoStateEvent.None -> {
                    // who cares
                }
            }
        }
    }

    fun setRepo(gitRepo: GitHubRepo){
        _repo.value = gitRepo
    }
}

sealed class RepoStateEvent {

    object GetRepoEvent : RepoStateEvent()

    object None : RepoStateEvent()
}
