package com.example.githubtask.models.domain

data class User(
    var login: String,
    var avatarUrl: String,
    var htmlUrl: String?,
    var name: String?,
    var location: String?,
    var bio: String?,
    var publicRepo: Int?,
    var reposUrl: String?,
    val followers: Int,
    val following: Int
)
