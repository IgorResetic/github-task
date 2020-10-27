package com.example.githubtask.di

import android.content.Context
import androidx.room.Room
import com.example.githubtask.persistence.GithubDatabase
import com.example.githubtask.persistence.RepoDao
import com.example.githubtask.persistence.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Singleton

@ExperimentalCoroutinesApi
@InstallIn(ApplicationComponent::class)
@Module
object PersistenceModule {

    @Singleton
    @Provides
    fun provideGitHubDatabase(@ApplicationContext context: Context): GithubDatabase {
        return Room
            .databaseBuilder(
                context,
                GithubDatabase::class.java,
                GithubDatabase.DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideUserDAO(gitHubDatabase: GithubDatabase): UserDao {
        return gitHubDatabase.userDao()
    }

    @Singleton
    @Provides
    fun provideRepoDAO(gitHubDatabase: GithubDatabase): RepoDao {
        return gitHubDatabase.repoDao()
    }
}
