package com.example.githubtask.repository

import android.util.Log
import com.example.githubtask.models.domain.GitHubRepo
import com.example.githubtask.network.GithubApiService
import com.example.githubtask.network.mappers.GitHUbRepoNetworkMapper
import com.example.githubtask.persistence.RepoDao
import com.example.githubtask.persistence.mappers.GitHubRepoMapper
import com.example.githubtask.util.DataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RepoRepository
constructor(
    private val repoDao: RepoDao,
    private val githubApiService: GithubApiService,
    private val gitHubRepoMapper: GitHubRepoMapper,
    private val gitHUbRepoNetworkMapper: GitHUbRepoNetworkMapper
) : Repository {
    suspend fun getGitHubRepo(owner: String, name: String): Flow<DataState<GitHubRepo>> = flow {
        emit(DataState.Loading)
        try {
            val networkRepo = githubApiService.getRepo(owner, name)
            val repo = gitHUbRepoNetworkMapper.mapFromEntity(networkRepo)
            repoDao.insert(gitHubRepoMapper.mapToEntity(repo))

            val cachedRepo = repoDao.load(owner, name)
            emit(DataState.Success(gitHubRepoMapper.mapFromEntity(cachedRepo)))
        } catch (e: Exception) {
            Log.d("RepoRepository", "" + e.message)
            emit(DataState.Error(e))
        }
    }
}
