package com.example.githubtask.ui.repositorydetail

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.example.githubtask.R
import com.example.githubtask.databinding.FragmentRepositoryDetailBinding
import com.example.githubtask.models.domain.GitHubRepo
import com.example.githubtask.util.DataState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_repository_detail.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import javax.inject.Inject

@ExperimentalCoroutinesApi
@FlowPreview
@AndroidEntryPoint
class RepositoryDetailFragment
@Inject
constructor() : Fragment() {

    private val viewModel: RepositoryDetailViewModel by viewModels()
    lateinit var binding: FragmentRepositoryDetailBinding
    private val args: RepositoryDetailFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = FragmentRepositoryDetailBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        subscribeObservers()
        viewModel.setStateEvent(RepoStateEvent.GetRepoEvent, args.owner, args.name)

        setupActionBarWithNavController(setOf(R.id.searchFragment), activity as AppCompatActivity)

        binding.btnCheckRepoOnGithub.setOnClickListener {
            (viewModel.repo.value?.htmlUrl).let {
                val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(it))
                startActivity(browserIntent)
            }
        }
    }

    private fun setupActionBarWithNavController(fragmentId: Set<Int>, activity: AppCompatActivity) {
        val appBarConfiguration = AppBarConfiguration(fragmentId)
        NavigationUI.setupActionBarWithNavController(
            activity,
            findNavController(),
            appBarConfiguration
        )
    }

    private fun subscribeObservers() {
        viewModel.dataState.observe(viewLifecycleOwner, Observer { dataState ->
            when (dataState) {
                is DataState.Success<GitHubRepo> -> {
                    viewModel.setRepo(dataState.data)
                }
                is DataState.Error -> {
                    Log.d("RepositoryDetail", "Error")
                }
                is DataState.Loading -> {
                    Log.d("RepositoryDetail", "Loading")
                }
            }
        })
    }
}
