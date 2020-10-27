package com.example.githubtask.persistence

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.githubtask.models.database.GItHubRepoEntity
import com.example.githubtask.models.database.RepoSearchResult

@Dao
interface RepoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(vararg repos: GItHubRepoEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertResult(result: RepoSearchResult)

    @Query("SELECT * FROM github_repos WHERE owner_login = :ownerLogin AND name = :name")
    suspend fun load(ownerLogin: String, name: String): GItHubRepoEntity

    @Query("SELECT * FROM github_repos WHERE id IN (:repoIds) ORDER BY watchers_count DESC")
    suspend fun getRepoByIds(repoIds: List<Int>): List<GItHubRepoEntity>

    @Query("SELECT * FROM github_repos WHERE id IN (:repoIds) ORDER BY :orderBy ASC")
    suspend fun getFilterRepoByIds(repoIds: List<Int>, orderBy: String): List<GItHubRepoEntity>

    @Query("SELECT * FROM github_repos WHERE id IN (:repoIds) ORDER BY forks_count DESC")
    suspend fun orderRepoByFork(repoIds: List<Int>): List<GItHubRepoEntity>

    @Query("SELECT * FROM github_repos WHERE id IN (:repoIds) ORDER BY starts_count DESC")
    suspend fun orderRepoByStars(repoIds: List<Int>): List<GItHubRepoEntity>

    @Query("SELECT * FROM github_repos WHERE id IN (:repoIds) ORDER BY updated_at DESC")
    suspend fun orderRepoByUpdateAt(repoIds: List<Int>): List<GItHubRepoEntity>

    @Query("SELECT * FROM RepoSearchResult WHERE `query` = :searchQuery")
    suspend fun getRepoIds(searchQuery: String): RepoSearchResult
}
