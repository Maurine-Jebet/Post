package com.kitur.assessment.api


import com.kitur.assessment.model.Post
import com.kitur.assessment.model.PostResponse

import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {

    @GET("/post")


    suspend fun getPost(): Response<List<Post>>

}