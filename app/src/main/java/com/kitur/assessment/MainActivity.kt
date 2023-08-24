package com.kitur.assessment

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.assessment.PostAdapter
import com.kitur.assessment.ViewModel.PostViewModel




class MainActivity : AppCompatActivity() {
    private val productViewModel: PostViewModel by PostViewModel()
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        productViewModel.fetchProducts()
        productViewModel.productLiveData.observe(this, Observer { productList->
            var postAdapter = PostAdapter(productList ?: emptyList())
            binding.rvPost.layoutManager = LinearLayoutManager(this@MainActivity)
            binding.rvPost.adapter = postAdapter
            Toast.makeText(baseContext, "fetched ${productList?.size} products", Toast.LENGTH_LONG).show()
        })

        productViewModel.errorLiveData.observe(this, Observer { error->
            Toast.makeText(baseContext, error, Toast.LENGTH_LONG).show()
        })
    }


}