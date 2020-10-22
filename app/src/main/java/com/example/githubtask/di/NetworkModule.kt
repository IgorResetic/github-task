package com.example.githubtask.di

import com.example.githubtask.network.GithubApiService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideMoshiBuilder(): Moshi {
        return Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofitBuilder(moshiBuilder: Moshi): Retrofit.Builder {
        return Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(MoshiConverterFactory.create(moshiBuilder).asLenient())
    }

    @Singleton
    @Provides
    fun provideGitHubApiService(retrofitBuilder: Retrofit.Builder): GithubApiService {
        return retrofitBuilder
            .build()
            .create(GithubApiService::class.java)
    }
}
