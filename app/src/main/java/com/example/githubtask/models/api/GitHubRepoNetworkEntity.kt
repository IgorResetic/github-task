package com.example.githubtask.models.api

import com.squareup.moshi.Json

data class GitHubRepoNetworkEntity(
    val name: String?,
    @Json(name = "full_name")
    val fullName: String?,
    val owner: RepoOwner,
    @Json(name = "html_url")
    val htmlUrl: String?,
    val description: String?,
    @Json(name = "stargazers_count")
    val stargazersCount: Int?,
    @Json(name = "watchers_count")
    val watchersCount: Int?,
    @Json(name = "forks_count")
    val forksCount: Int?,
    val language: String?
)

data class RepoOwner(
    val login: String?,
    val avatarUrl: String?
)
