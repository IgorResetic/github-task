package com.example.githubtask.models.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import com.example.githubtask.models.Owner

@Entity(tableName = "github_repos",
    primaryKeys = ["name", "owner_login"]
)
data class GItHubRepoEntity(

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "full_name")
    val fullName: String,

    @ColumnInfo(name = "owner")
    val owner: Owner,

    @ColumnInfo(name = "html_url")
    val htmlUrl: String,

    @ColumnInfo(name = "description")
    val description: String?,

    @ColumnInfo(name = "starts_count")
    val starsCount: Int,

    @ColumnInfo(name = "forks_count")
    val forksCount: Int,

    @ColumnInfo(name = "watchers_count")
    val watchersCount: Int,

    @ColumnInfo(name = "language")
    val language: String?
)
