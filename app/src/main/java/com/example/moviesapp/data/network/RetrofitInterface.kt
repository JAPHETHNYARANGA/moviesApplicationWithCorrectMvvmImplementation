package com.example.moviesapp.data.network

import com.example.moviesapp.domain.models.MoviesModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitInterface {
    @GET("/")
    fun getMovies(@Query("apikey")apikey:String, @Query("s")action:String) : Call<MoviesModel>
}