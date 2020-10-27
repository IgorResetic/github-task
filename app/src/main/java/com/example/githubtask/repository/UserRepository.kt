package com.example.githubtask.repository

import android.util.Log
import com.example.githubtask.models.domain.User
import com.example.githubtask.network.GithubApiService
import com.example.githubtask.network.mappers.UserNetworkMapper
import com.example.githubtask.persistence.UserDao
import com.example.githubtask.persistence.mappers.UserMapper
import com.example.githubtask.util.DataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception

class UserRepository
constructor(
    private val userDao: UserDao,
    private val githubApiService: GithubApiService,
    private val userMapper: UserMapper,
    private val userNetworkMapper: UserNetworkMapper
) : Repository {
    suspend fun getUser(login: String): Flow<DataState<User>> = flow {
        emit(DataState.Loading)
        try {
            val networkUser = githubApiService.getUser(login)
            val user = userNetworkMapper.mapFromEntity(networkUser)
            userDao.insert(userMapper.mapToEntity(user))

            val cachedUser = userDao.findByLogin(login)
            emit(DataState.Success(userMapper.mapFromEntity(cachedUser)))
        } catch (e: Exception) {
            emit(DataState.Error(e))
        }
    }
}
