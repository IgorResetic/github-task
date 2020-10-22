package com.example.githubtask.di

import androidx.fragment.app.FragmentFactory
import com.example.githubtask.navigation.MainFragmentFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object MainModule {

    @Singleton
    @Provides
    fun provideFragmentFactory(): FragmentFactory {
        return MainFragmentFactory()
    }
}
