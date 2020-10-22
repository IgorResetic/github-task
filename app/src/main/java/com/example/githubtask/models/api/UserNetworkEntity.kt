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
    @Json(name = "public_repo")
    val publicRepo: String?,
    @Json(name = "repos_url")
    val reposUrl: String?
)
