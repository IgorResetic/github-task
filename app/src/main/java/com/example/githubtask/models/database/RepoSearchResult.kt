package com.example.githubtask.models.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.TypeConverters
import com.example.githubtask.persistence.GithubTypeConverters

@Entity(primaryKeys = ["query"])
@TypeConverters(GithubTypeConverters::class)
data class RepoSearchResult(

    @ColumnInfo(name = "query")
    val query: String,

    @ColumnInfo(name = "repoIds")
    val repoIds: List<Int>,

    @ColumnInfo(name = "total_count")
    val totalCount: Int,
)
