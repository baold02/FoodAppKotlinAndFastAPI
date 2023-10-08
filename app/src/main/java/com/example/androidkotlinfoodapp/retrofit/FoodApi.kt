package com.example.androidkotlinfoodapp.retrofit

import com.example.androidkotlinfoodapp.model.category
import retrofit2.Call
import retrofit2.http.GET

interface FoodApi {
    @GET("category.php")
    fun getCategory() : Call<category>
}