package com.kitur.assessment.Repository


import com.kitur.assessment.api.ApiClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import com.kitur.assessment.api.ApiInterface
import com.kitur.assessment.model.Post

import retrofit2.Response



class PostRepository {
    val apiClient = ApiClient.buildClient(ApiInterface::class.java)

    suspend fun getPost(): Response<List<Post>> {
        return withContext(Dispatchers.IO) {
            apiClient.getPost()
        }
    }
}
