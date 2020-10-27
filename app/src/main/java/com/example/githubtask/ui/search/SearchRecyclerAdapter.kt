package com.example.githubtask.ui.search

import android.text.Layout
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.githubtask.R
import com.example.githubtask.databinding.LayoutSearchRepoItemBinding
import com.example.githubtask.models.domain.GitHubRepo
import com.example.githubtask.ui.userdetail.UserDetailFragmentDirections

class SearchRecyclerAdapter : RecyclerView.Adapter<SearchRecyclerAdapter.ViewHolder>() {

    private val items: MutableList<GitHubRepo> = mutableListOf()

    val DIFF_CALLBACK = object : DiffUtil.ItemCallback<GitHubRepo>() {

        override fun areItemsTheSame(oldItem: GitHubRepo, newItem: GitHubRepo): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: GitHubRepo, newItem: GitHubRepo): Boolean {
            return oldItem == newItem
        }
    }
    private val differ = AsyncListDiffer(this, DIFF_CALLBACK)

    class ViewHolder(val binding: LayoutSearchRepoItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    fun addGitHubRepoList(gitRepoList: List<GitHubRepo>) {
        items.addAll(gitRepoList)
        notifyDataSetChanged()
    }

    fun clearGitHubRepoList() {
        items.clear()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<LayoutSearchRepoItemBinding>(
            inflater, R.layout.layout_search_repo_item, parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.binding.apply {
            repo = item
        }

        holder.binding.iwUserImage.setOnClickListener {
            val login = item.owner.login
            it.findNavController().navigate(SearchFragmentDirections.actionSearchFragmentToUserDetailFragment(login))
        }

        holder.binding.clRepoItemRoot.setOnClickListener {
            val repoName = item.name
            val repoOwner = item.owner.login
            it.findNavController().navigate(SearchFragmentDirections
                .actionSearchFragmentToRepositoryDetailFragment(repoOwner, repoName))
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}
