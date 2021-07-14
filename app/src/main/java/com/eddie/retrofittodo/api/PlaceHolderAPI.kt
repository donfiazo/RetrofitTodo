package com.eddie.retrofittodo.api

import com.eddie.retrofittodo.models.User
import retrofit2.Call
import retrofit2.http.GET

interface PlaceHolderAPI {
    @GET("users")
    fun getUsers(): Call<List<User>>
}