package com.example.githubtask.ui.userdetail

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
import androidx.navigation.NavArgs
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.example.githubtask.R
import com.example.githubtask.databinding.FragmentUserDetailBinding
import com.example.githubtask.models.domain.User
import com.example.githubtask.util.DataState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Inject

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class UserDetailFragment
@Inject
constructor() : Fragment() {

    private val viewModel: UserDetailViewModel by viewModels()
    lateinit var binding: FragmentUserDetailBinding
    private val args: UserDetailFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = FragmentUserDetailBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscribeObservers()
        viewModel.setStateEvent(UserStateEvent.GetUserEvent, args.userLogin)

        binding.btnCheckOnGithub.setOnClickListener {
            (viewModel.user.value?.htmlUrl).let {
                val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(it))
                startActivity(browserIntent)
            }
        }

        setupActionBarWithNavController(setOf(R.id.searchFragment), activity as AppCompatActivity)
    }

    private fun setupActionBarWithNavController(fragmentId: Set<Int>, activity: AppCompatActivity) {
        val appBarConfiguration = AppBarConfiguration(fragmentId);
        NavigationUI.setupActionBarWithNavController(
            activity,
            findNavController(),
            appBarConfiguration
        )
    }

    private fun subscribeObservers() {
        viewModel.dataState.observe(viewLifecycleOwner, Observer { dataState ->
            when (dataState) {
                is DataState.Success<User> -> {
                    viewModel.setUser(dataState.data)
                }
                is DataState.Error -> {
                    Log.d("UserDetailFragment", "Error")
                }
                is DataState.Loading -> {
                    Log.d("UserDetailFragment", "Loading")
                }
            }
        })
    }
}
