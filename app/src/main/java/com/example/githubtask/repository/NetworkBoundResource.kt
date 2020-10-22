package com.example.githubtask.repository

import androidx.lifecycle.MediatorLiveData
import com.example.githubtask.util.Resource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

@FlowPreview
abstract class NetworkBoundResource <ResultType, RequestType>
{
    private val result = MediatorLiveData<Resource<ResultType>>()

    init {

    }

}
