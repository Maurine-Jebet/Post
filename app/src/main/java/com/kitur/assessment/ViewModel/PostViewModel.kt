package com.kitur.assessment.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kitur.assessment.Repository.PostRepository

import com.kitur.assessment.model.Post
import kotlinx.coroutines.launch


class PostViewModel : ViewModel() {
     var postRepo = PostRepository()
    val postLiveData = MutableLiveData<List<Post>>()
    val errorLiveData = MutableLiveData<String>()

    fun fetchProducts() {
        viewModelScope.launch {
            val response = postRepo.getPost()
            if (response.isSuccessful) {
                val postList=response.body()?: emptyList()
                postLiveData.postValue(postList
                        as List<Post>)

            } else {
                errorLiveData.postValue(response.errorBody()?.string())
            }
        }
    }


}
