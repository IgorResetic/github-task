package com.example.githubtask.ui.userdetail

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.githubtask.models.domain.User
import com.example.githubtask.repository.UserRepository
import com.example.githubtask.util.DataState
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

@ExperimentalCoroutinesApi
class UserDetailViewModel
@ViewModelInject
constructor(
    private val userRepository: UserRepository
) : ViewModel() {

    private val _dataState: MutableLiveData<DataState<User>> = MutableLiveData()

    val dataState: LiveData<DataState<User>>
        get() = _dataState

    private val _user = MutableLiveData<User>()

    val user: LiveData<User>
        get() = _user

    fun setStateEvent(userStateEvent: UserStateEvent, login: String) {
        viewModelScope.launch {
            when(userStateEvent){
                is UserStateEvent.GetUserEvent -> {
                    userRepository.getUser(login)
                        .onEach {dataState ->
                            _dataState.value = dataState
                        }
                        .launchIn(viewModelScope)
                }

                UserStateEvent.None -> {
                    // who cares
                }
            }
        }
    }

    fun setUser(gitUser: User){
        _user.value = gitUser
    }
}

sealed class UserStateEvent {

    object GetUserEvent : UserStateEvent()

    object None : UserStateEvent()
}
