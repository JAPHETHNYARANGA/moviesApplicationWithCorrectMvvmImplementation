package com.example.moviesapp.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.moviesapp.domain.models.MoviesModel
import com.example.moviesapp.domain.useCase.GetMoviesUseCase

class MoviesViewModel(private  val moviesUseCase: GetMoviesUseCase): ViewModel() {
    val moviesLiveData:LiveData<MoviesModel> get() = moviesUseCase()

}