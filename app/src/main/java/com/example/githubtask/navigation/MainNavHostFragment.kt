package com.example.githubtask.navigation

import android.content.Context
import android.os.Bundle
import androidx.annotation.NavigationRes
import androidx.navigation.fragment.NavHostFragment
import com.example.githubtask.ui.MainActivity

class MainNavHostFragment : NavHostFragment() {

    override fun onAttach(context: Context) {
        childFragmentManager.fragmentFactory =
            (activity as MainActivity).fragmentFactory
        super.onAttach(context)
    }

    companion object {

        private const val KEY_GRAPH_ID = "android-support-nav:fragment:graphId"

        @JvmStatic
        fun create(
            @NavigationRes graphId: Int = 0
        ): MainNavHostFragment {
            var bundle: Bundle? = null
            if (graphId != 0) {
                bundle = Bundle()
                bundle.putInt(KEY_GRAPH_ID, graphId)
            }
            val result =
                MainNavHostFragment()
            if (bundle != null) {
                result.arguments = bundle
            }
            return result
        }
    }
}
