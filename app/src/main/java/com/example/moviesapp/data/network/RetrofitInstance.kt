package com.example.moviesapp.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    fun getMoviesInstance() : RetrofitInterface{
        val BASE_URL="https://www.omdbapi.com"

        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
        return retrofit.create(RetrofitInterface::class.java)
    }

}