package com.example.githubtask.navigation

import androidx.fragment.app.FragmentFactory
import androidx.lifecycle.ViewModelProvider
import com.example.githubtask.ui.repositorydetail.RepositoryDetailFragment
import com.example.githubtask.ui.search.SearchFragment
import com.example.githubtask.ui.userdetail.UserDetailFragment
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MainFragmentFactory
@Inject
constructor() : FragmentFactory() {
    @FlowPreview
    @ExperimentalCoroutinesApi
    override fun instantiate(classLoader: ClassLoader, className: String) =

        when (className) {

            SearchFragment::class.java.name -> {
                SearchFragment()
            }

            RepositoryDetailFragment::class.java.name -> {
                RepositoryDetailFragment()
            }

            UserDetailFragment::class.java.name -> {
                UserDetailFragment()
            }

            else -> {
                SearchFragment()
            }
        }
}
