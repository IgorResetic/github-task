package com.example.githubtask.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.githubtask.R
import com.example.githubtask.network.GithubApiService
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject lateinit var githubApiService: GithubApiService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()

        // Test delete after finishing
        val mainActivityJob = Job()
        val coroutineScope = CoroutineScope(mainActivityJob)

        coroutineScope.launch {
            val result = githubApiService.getRepo("flutter", "flutter")
            result.htmlUrl?.let { Log.d("TestRetrofit", it) }
        }
    }
}
