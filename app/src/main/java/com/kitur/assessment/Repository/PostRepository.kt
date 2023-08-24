package com.kitur.assessment.Repository

import com.kitur.assessment.api.ApiClient
import com.kitur.assessment.api.ApiInterface
import com.kitur.assessment.model.Post
import com.kitur.assessment.model.PostResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PostRepository {


    class PostRepository {
        private val apiClient = ApiClient.buildClient(ApiInterface::class.java)

        suspend fun getProducts(): Response<PostResponse>{
            return withContext(Dispatchers.IO){
                apiClient.getPost()
            }
        }
    }
}