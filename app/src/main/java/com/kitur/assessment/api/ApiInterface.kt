package com.kitur.assessment.api


import com.kitur.assessment.model.Post
import com.kitur.assessment.model.PostResponse

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {

    @GET("/product")

    suspend fun getProducts():Response<PostResponse>

    @GET("/product/{id}")
    suspend fun getProductById(@Path("id")postId:Int):Response<Post>

}