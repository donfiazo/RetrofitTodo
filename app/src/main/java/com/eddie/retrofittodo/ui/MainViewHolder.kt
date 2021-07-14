package com.eddie.retrofittodo.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.eddie.retrofittodo.api.RetrofitProvider
import com.eddie.retrofittodo.models.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewHolder : ViewModel() {

    val usersLiveData = MutableLiveData<List<User>>()

    fun getUsers(){
        RetrofitProvider.placeHolderAPI.getUsers().enqueue(object : Callback<List<User>> {
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
               response.body()?.let {
                   usersLiveData.postValue(it)
               }
            }

            override fun onFailure(call: Call<List<User>>, t: Throwable) {

            }


        })
    }
}