package com.example.githubtask.ui.search

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.customview.customView
import com.afollestad.materialdialogs.customview.getCustomView
import com.example.githubtask.R
import com.example.githubtask.databinding.FragmentSearchBinding
import com.example.githubtask.models.domain.GitHubRepo
import com.example.githubtask.util.DataState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.layout_search_view_toolbar.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Inject

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class SearchFragment
@Inject
constructor() : Fragment() {

    private val viewModel: SearchViewModel by viewModels()
    private lateinit var binding: FragmentSearchBinding
    private lateinit var gitRepoAdapter: SearchRecyclerAdapter
    private lateinit var q: String

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = FragmentSearchBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()

        subscribeObservers()
        search_view.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let { viewModel.setQuery(it) }
                search_view.clearFocus()
                query?.let { viewModel.setStateEvent(MainStateEvent.GetReposEvent, it) }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return true
            }
        })

        action_filter.setOnClickListener {
            showFilterDialog()
        }
    }

    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity).supportActionBar?.hide()
    }

    override fun onPause() {
        super.onPause()
        (activity as AppCompatActivity).supportActionBar?.show()
    }

    private fun subscribeObservers() {
        viewModel.dataState.observe(viewLifecycleOwner, { dataState ->
            when (dataState) {
                is DataState.Success<List<GitHubRepo>> -> {
                    gitRepoAdapter.clearGitHubRepoList()
                    displayProgressBar(false)
                    viewModel.setRepoIds(dataState.data.map { it.id })
                    gitRepoAdapter.addGitHubRepoList(dataState.data)
                }
                is DataState.Error -> {
                    displayProgressBar(false)
                    Log.d("SearchFragment", "Error")
                }
                is DataState.Loading -> {
                    displayProgressBar(true)
                    Log.d("SearchFragment", "Loading")
                }
            }
        })
    }

    private fun initRecyclerView() {
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            gitRepoAdapter = SearchRecyclerAdapter()
            adapter = gitRepoAdapter
        }
    }

    fun showFilterDialog() {

        activity?.let {
            val dialog = MaterialDialog(it)
                .noAutoDismiss()
                .customView(R.layout.layout_repo_filter)

            val view = dialog.getCustomView()
            var orderBy: String = SearchViewModel.ORDER_BY_UPDATE_AT

            view.findViewById<RadioGroup>(R.id.filter).setOnCheckedChangeListener { _, i ->
                when (view.findViewById<RadioButton>(i).text as String) {
                    "Stars" -> orderBy = SearchViewModel.ORDER_BY_STARS
                    "Forks" -> orderBy = SearchViewModel.ORDER_BY_FORKS
                    "Update" -> orderBy = SearchViewModel.ORDER_BY_UPDATE_AT
                    else -> SearchViewModel.ORDER_BY_UPDATE_AT
                }
            }

            view.findViewById<TextView>(R.id.positive_button).setOnClickListener {
                viewModel.setStateEvent(mainStateEvent = MainStateEvent.GetOrderReposEvent, orderBy = orderBy)
                dialog.dismiss()
            }

            view.findViewById<TextView>(R.id.negative_button).setOnClickListener {
                dialog.dismiss()
            }

            dialog.show()
        }
    }

    private fun displayProgressBar(isDisplayed: Boolean) {
        binding.progressBar.visibility = if (isDisplayed) View.VISIBLE else View.GONE
    }
}
