package com.example.githubtask.di

import com.example.githubtask.network.GithubApiService
import com.example.githubtask.network.mappers.GitHUbRepoNetworkMapper
import com.example.githubtask.network.mappers.UserNetworkMapper
import com.example.githubtask.persistence.RepoDao
import com.example.githubtask.persistence.UserDao
import com.example.githubtask.persistence.mappers.GitHubRepoMapper
import com.example.githubtask.persistence.mappers.UserMapper
import com.example.githubtask.repository.RepoRepository
import com.example.githubtask.repository.SearchRepository
import com.example.githubtask.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideUserRepository(
        userDao: UserDao,
        githubApiService: GithubApiService,
        userMapper: UserMapper,
        userNetworkMapper: UserNetworkMapper
    ): UserRepository {
        return UserRepository(userDao, githubApiService, userMapper, userNetworkMapper)
    }

    @Singleton
    @Provides
    fun provideRepoRepository(
        repoDao: RepoDao,
        githubApiService: GithubApiService,
        gitHubRepoMapper: GitHubRepoMapper,
        gitHUbRepoNetworkMapper: GitHUbRepoNetworkMapper
    ): RepoRepository {
        return RepoRepository(repoDao, githubApiService, gitHubRepoMapper, gitHUbRepoNetworkMapper)
    }

    @Singleton
    @Provides
    fun provideSearchRepository(
        repoDao: RepoDao,
        githubApiService: GithubApiService,
        gitHubRepoMapper: GitHubRepoMapper,
        gitHUbRepoNetworkMapper: GitHUbRepoNetworkMapper
    ): SearchRepository {
        return SearchRepository(repoDao, githubApiService, gitHubRepoMapper, gitHUbRepoNetworkMapper)
    }
}
