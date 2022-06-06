package com.example.moviesapp.domain.useCase

import androidx.lifecycle.LiveData
import com.example.moviesapp.domain.models.MoviesModel
import com.example.moviesapp.domain.repository.MoviesInterface

class GetMoviesUseCase(var moviesInterface: MoviesInterface) {
    operator fun invoke() : LiveData<MoviesModel> = moviesInterface.getMovies()
}