package com.example.githubtask.repository

import android.util.Log
import com.example.githubtask.models.database.RepoSearchResult
import com.example.githubtask.models.domain.GitHubRepo
import com.example.githubtask.network.GithubApiService
import com.example.githubtask.network.mappers.GitHUbRepoNetworkMapper
import com.example.githubtask.persistence.RepoDao
import com.example.githubtask.persistence.mappers.GitHubRepoMapper
import com.example.githubtask.ui.search.SearchViewModel
import com.example.githubtask.util.DataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception

class SearchRepository
constructor(
    private val repoDao: RepoDao,
    private val githubApiService: GithubApiService,
    private val gitHubRepoMapper: GitHubRepoMapper,
    private val gitHUbRepoNetworkMapper: GitHUbRepoNetworkMapper
) : Repository {

    suspend fun searchGitHub(query: String): Flow<DataState<List<GitHubRepo>>> = flow {
        emit(DataState.Loading)
        try {
            val networkSearch = githubApiService.searchRepos(query)
            val repos = gitHUbRepoNetworkMapper.mapFromEntityList(networkSearch.items)
            val repoIds = networkSearch.items.map { it.id }

            repoDao.insertResult(RepoSearchResult(
                query = query,
                repoIds = repoIds,
                totalCount = networkSearch.total
            ))

            for (repo in repos) {
                repoDao.insert(gitHubRepoMapper.mapToEntity(repo))
            }

            val cacheRepos = repoDao.getRepoByIds(repoIds)
            emit(DataState.Success(gitHubRepoMapper.mapFromEntityList(cacheRepos)))
        } catch (e: Exception) {
            Log.d("SearchRepository", "" + e.message)
            emit(DataState.Error(e))
        }
    }

    suspend fun orderGitHubRepos(searchQuery: String, orderBy: String): Flow<DataState<List<GitHubRepo>>> = flow {
        emit(DataState.Loading)

        val repoSearch = repoDao.getRepoIds(searchQuery)

        val cacheRepos = when (orderBy) {
            SearchViewModel.ORDER_BY_FORKS -> {
                repoDao.orderRepoByFork(repoSearch.repoIds)
            }
            SearchViewModel.ORDER_BY_STARS -> {
                repoDao.orderRepoByStars(repoSearch.repoIds)
            }
            SearchViewModel.ORDER_BY_UPDATE_AT -> {
                repoDao.orderRepoByUpdateAt(repoSearch.repoIds)
            }
            else -> {
                repoDao.orderRepoByFork(repoSearch.repoIds)
            }
        }

        try {
            emit(DataState.Success(gitHubRepoMapper.mapFromEntityList(cacheRepos)))
        } catch (e: Exception) {
            emit(DataState.Error(e))
        }
    }
}
