package com.kitur.assessment.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.kitur.assessment.PostAdapter

import com.kitur.assessment.databinding.ActivityMainBinding
import com.kitur.assessment.model.Post
import com.kitur.assessment.viewModel.PostViewModel


class MainActivity : AppCompatActivity() {
    val postViewModel: PostViewModel by viewModels()
    lateinit var binding: ActivityMainBinding
    lateinit var postAdapter: PostAdapter

    var postList: List<Post> = emptyList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        postAdapter = PostAdapter(emptyList())
    }

    override fun onResume() {
        super.onResume()
        postViewModel.fetchProducts()

        postViewModel.postLiveData.observe(this, Observer { postList->

            var postAdapter = PostAdapter(postList ?: emptyList())
            binding.rvPost.layoutManager = GridLayoutManager(this, 2)
            binding.rvPost.adapter = postAdapter
            Toast
                .makeText(baseContext, "fetched ${postList?.size}products", Toast.LENGTH_LONG)
                .show()

        })


        postViewModel.errorLiveData.observe(this, Observer { error ->

            Toast.makeText(baseContext, error, Toast.LENGTH_LONG).show()


        })
    }
}