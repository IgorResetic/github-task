package com.example.githubtask.models.api

data class RepoSearchResponse(
    val total: Int = 0,
    val items: List<GitHubRepoNetworkEntity>
)
