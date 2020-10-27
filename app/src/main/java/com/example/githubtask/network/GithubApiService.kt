package com.example.githubtask.network

import com.example.githubtask.models.api.GitHubRepoNetworkEntity
import com.example.githubtask.models.api.RepoSearchResponse
import com.example.githubtask.models.api.UserNetworkEntity
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GithubApiService {

    @GET("users/{login}")
    suspend fun getUser(@Path("login") login: String): UserNetworkEntity

    @GET("repos/{owner}/{name}")
    suspend fun getRepo(
        @Path("owner") owner: String,
        @Path("name") name: String
    ): GitHubRepoNetworkEntity

    @GET("search/repositories")
    suspend fun searchRepos(@Query("q") query: String): RepoSearchResponse
}
