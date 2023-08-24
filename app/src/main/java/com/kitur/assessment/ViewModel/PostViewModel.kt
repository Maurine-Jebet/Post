package com.kitur.assessment.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kitur.assessment.Repository.PostRepository
import com.kitur.assessment.model.Post

class PostViewModel:ViewModel() {



        private var productRepo = PostRepository()
        val productLiveData = MutableLiveData<List<Post>>()
        val errorLiveData = MutableLiveData<String>()

        fun fetchProducts(){
            ViewModelScope.launch{
                val response = productRepo.getPost()
                if (response.isSuccessful){
                    productLiveData.postValue(response.body()?.products)
                }
                else{
                    errorLiveData.postValue(response.errorBody()?.string())
                }
            }
        }


    }
}