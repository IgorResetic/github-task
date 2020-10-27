package com.example.githubtask.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.githubtask.models.database.GItHubRepoEntity
import com.example.githubtask.models.database.RepoSearchResult
import com.example.githubtask.models.database.UserEntity
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@Database(
    entities = [
        UserEntity::class,
        GItHubRepoEntity::class,
        RepoSearchResult::class ],
    version = 11,
    exportSchema = false
)
abstract class GithubDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

    abstract fun repoDao(): RepoDao

    companion object {
        const val DATABASE_NAME: String = "blog_db"
    }
}
