package com.example.androidkotlinfoodapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.androidkotlinfoodapp.databinding.ItemCategoryBinding
import com.example.androidkotlinfoodapp.model.Reslut

class AdapterCategory(): RecyclerView.Adapter<AdapterCategory.ViewHolder>() {
    private var categoryList = ArrayList<Reslut>()

    class ViewHolder(var binding : ItemCategoryBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemCategoryBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return  categoryList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(holder.itemView).load(categoryList[position].categoryThumb).into(holder.binding.imgFood)
        holder.binding.tvName.text = categoryList[position].category
    }

    fun setDataCate(category : ArrayList<Reslut>){
        this.categoryList = category
        notifyDataSetChanged()
    }
}