package com.example.githubtask.models.api

import com.example.githubtask.models.Owner
import com.squareup.moshi.Json

data class GitHubRepoNetworkEntity(
    val id: Int,
    val name: String,
    @Json(name = "full_name")
    val fullName: String,
    val owner: Owner,
    @Json(name = "html_url")
    val htmlUrl: String?,
    val description: String?,
    @Json(name = "stargazers_count")
    val stargazersCount: Int?,
    @Json(name = "watchers_count")
    val watchersCount: Int?,
    @Json(name = "forks_count")
    val forksCount: Int?,
    @Json(name = "open_issues_count")
    val openIssuesCount: Int?,
    val language: String?,
    @Json(name = "updated_at")
    val updatedAt: String?,
    @Json(name = "created_at")
    val createdAt: String?
)
