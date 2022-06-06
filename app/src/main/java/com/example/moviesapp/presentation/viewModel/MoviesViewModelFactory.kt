package com.example.moviesapp.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.moviesapp.domain.useCase.GetMoviesUseCase

class MoviesViewModelFactory(private val moviesUseCase: GetMoviesUseCase):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MoviesViewModel(moviesUseCase) as T
    }

}