
package com.example.assessment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kitur.assessment.model.Post
import com.squareup.picasso.Picasso



class PostAdapter (var productList:List<Post>):RecyclerView.Adapter<PostAdapter.ProductViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        var binding=PostDisplayBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return  ProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        var currentProduct = productList[position]
        holder.bind(currentProduct)
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    inner class ProductViewHolder(private val binding: PostDisplayBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(currentProduct: Post){
            binding.apply {
                binding.tvId.text = currentProduct.id.toString()
                binding.tvTitle.text = currentProduct.title.toString()
                binding.tvDescription.text = currentProduct.description.toString()


                Picasso.get()

            }
        }
    }
}
