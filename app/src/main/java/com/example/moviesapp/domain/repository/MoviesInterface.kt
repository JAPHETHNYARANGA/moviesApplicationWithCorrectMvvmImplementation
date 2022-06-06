package com.example.moviesapp.domain.repository

import androidx.lifecycle.LiveData
import com.example.moviesapp.data.network.RetrofitInstance
import com.example.moviesapp.data.network.RetrofitInterface
import com.example.moviesapp.domain.models.MoviesModel
import retrofit2.Call

interface MoviesInterface  {
    fun getMovies() : LiveData<MoviesModel>
}