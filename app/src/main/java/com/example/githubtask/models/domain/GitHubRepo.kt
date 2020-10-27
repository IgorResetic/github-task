package com.example.githubtask.models.domain

import com.example.githubtask.models.Owner

data class GitHubRepo(
    val id: Int,
    val name: String,
    val fullName: String,
    val owner: Owner,
    val htmlUrl: String?,
    val description: String?,
    val stargazersCount: Int?,
    val watchersCount: Int?,
    val forksCount: Int?,
    val language: String?,
    val openIssuesCount: Int?,
    val updatedAt: String?,
    val createdAt: String?
)
