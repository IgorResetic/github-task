package com.example.githubtask.models.database

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(primaryKeys = ["login"],
    tableName = "github_users")
data class UserEntity(
    @ColumnInfo(name = "login")
    val login: String,

    @ColumnInfo(name = "avatar_url")
    val avatarUrl: String?,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "repos_url")
    val reposUrl: String?
)
