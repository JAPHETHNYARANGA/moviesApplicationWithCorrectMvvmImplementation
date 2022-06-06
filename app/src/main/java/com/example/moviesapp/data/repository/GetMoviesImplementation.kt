package com.example.moviesapp.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.moviesapp.data.network.RetrofitInstance
import com.example.moviesapp.domain.models.MoviesModel
import com.example.moviesapp.domain.repository.MoviesInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GetMoviesImplementation:MoviesInterface {
    override fun getMovies(): LiveData<MoviesModel> {
        val data:MutableLiveData<MoviesModel> = MutableLiveData()
        val getMovies = RetrofitInstance.getMoviesInstance().getMovies("c4b02832","action")


        getMovies.enqueue(object : Callback<MoviesModel>{
            override fun onResponse(call: Call<MoviesModel>, response: Response<MoviesModel>) {
                if(response.isSuccessful){
                    data.value= response.body()
                    Log.i("response","Sucessful response")
                }else{
                    Log.i("response", "Failed Response")
                }
            }

            override fun onFailure(call: Call<MoviesModel>, t: Throwable) {
                Log.i("response", "Failed Response returned on failure")
            }

        })
        return data
    }

}