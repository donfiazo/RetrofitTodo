package com.eddie.retrofittodo.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitProvider {

    private val retrofit = Retrofit.Builder()
        .baseUrl("http://jsonplaceholder.typicode.com/")
        .addConverterFactory(GsonConverterFactory.create()).build()
    val placeHolderAPI = retrofit.create(PlaceHolderAPI::class.java)
}