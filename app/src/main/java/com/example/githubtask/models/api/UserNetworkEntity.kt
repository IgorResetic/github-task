package com.example.githubtask.models.api

import com.squareup.moshi.Json

data class UserNetworkEntity(
    val login: String,
    @Json(name = "avatar_url")
    val avatarUrl: String,
    @Json(name = "html_url")
    val htmlUrl: String?,
    val name: String?,
    val location: String?,
    val bio: String?,
    @Json(name = "public_repos")
    val publicRepo: Int?,
    @Json(name = "repos_url")
    val reposUrl: String?,
    val followers: Int,
    val following: Int
)
