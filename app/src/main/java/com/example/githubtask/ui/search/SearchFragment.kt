package com.example.githubtask.ui.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.githubtask.R
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_search.*

class SearchFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        toRepo.setOnClickListener { navRepo() }

        toUser.setOnClickListener { navUser() }
    }

    private fun navRepo() {
        findNavController().navigate(R.id.action_searchFragment_to_repositoryDetailFragment)
    }
    private fun navUser() {
        findNavController().navigate(R.id.action_searchFragment_to_userDetailFragment)
    }
}
