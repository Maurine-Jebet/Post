package com.kitur.assessment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kitur.assessment.databinding.ActivityPostBinding
import com.kitur.assessment.model.Post


class PostAdapter(var postList: List<Post>) :
    RecyclerView.Adapter<ProductViewHolder>() {
    lateinit var binding: ActivityPostBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {

        var binding =
            ActivityPostBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductViewHolder(binding)
    }


    override fun getItemCount(): Int {
        return postList.size
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val currentItem = postList[position]
        val binding = holder.binding
        binding.tvBody.text = currentItem.body
        binding.tvId.text = currentItem.id.toString()
        binding.tvTitle.text = currentItem.title


    }
}

class ProductViewHolder(var binding: ActivityPostBinding) :
    RecyclerView.ViewHolder(binding.root)




