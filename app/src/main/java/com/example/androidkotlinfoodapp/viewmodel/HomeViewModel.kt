package com.example.androidkotlinfoodapp.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androidkotlinfoodapp.model.Reslut
import com.example.androidkotlinfoodapp.model.category
import com.example.androidkotlinfoodapp.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Response

class HomeViewModel() : ViewModel() {
    private var categoryLiveData = MutableLiveData<List<Reslut>>()
    fun getCategory(){
        RetrofitClient.api.getCategory().enqueue(object : retrofit2.Callback<category>{
            override fun onResponse(call: Call<category>, response: Response<category>) {
                response.body()?.let { category1 ->
                       categoryLiveData.postValue(category1.reslut)

                }

            }

            override fun onFailure(call: Call<category>, t: Throwable) {
                Log.e("logg",t.message.toString())
            }

        })
    }


    fun obseverCategoryLiveData() : LiveData<List<Reslut>>{
        return  categoryLiveData
    }
}