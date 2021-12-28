package com.ktor.application.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.ktor.application.R
import com.ktor.application.databinding.ItemPostBinding
import com.ktor.application.model.response.PostResponse
import com.ktor.application.viewmodel.PostsAdapterViewModel


class PostItemAdapter(
    val data: ArrayList<PostResponse>,

) : RecyclerView.Adapter<PostItemAdapter.PostItemViewHolder>() {

    var filterList: ArrayList<PostResponse>

    init {
        filterList = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostItemViewHolder {
         val binding = DataBindingUtil.inflate<ItemPostBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_post,
            parent,
            false
        )
        return PostItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PostItemViewHolder, position: Int) =
        holder.bind(filterList[position])

    override fun getItemCount(): Int {
        return filterList.size
    }

    inner class PostItemViewHolder(private val binding: ItemPostBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(postResponse: PostResponse) {
            binding.viewModel = PostsAdapterViewModel(postResponse)
        }
    }


    fun updateList(filteredList: ArrayList<PostResponse>) {
        filterList = filteredList
        notifyDataSetChanged()
    }
}