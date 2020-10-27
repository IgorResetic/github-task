package com.example.githubtask.models

import com.squareup.moshi.Json

data class Owner(
    val login: String,
    @Json(name = "avatar_url")
    val avatarUrl: String?
)
