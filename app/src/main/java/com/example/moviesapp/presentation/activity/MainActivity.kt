package com.example.moviesapp.presentation.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moviesapp.data.repository.GetMoviesImplementation
import com.example.moviesapp.databinding.ActivityMainBinding
import com.example.moviesapp.domain.models.Search
import com.example.moviesapp.domain.useCase.GetMoviesUseCase
import com.example.moviesapp.presentation.adapter.MoviesAdapter
import com.example.moviesapp.presentation.viewModel.MoviesViewModel
import com.example.moviesapp.presentation.viewModel.MoviesViewModelFactory

class MainActivity : AppCompatActivity() {
    //adapter
    private lateinit var moviesAdapter: MoviesAdapter


    //viewModel
    private val viewModel:MoviesViewModel by viewModels{
        MoviesViewModelFactory(moviesUseCase = GetMoviesUseCase(GetMoviesImplementation()) )
    }


    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        initRecyclerView()

        viewModel.moviesLiveData.observe(this){data ->
            if(data != null)moviesAdapter.moviesListData(data.Search as ArrayList<Search>)
            moviesAdapter.notifyDataSetChanged()
        }
    }

    private fun initRecyclerView() {
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            moviesAdapter = MoviesAdapter()
            adapter = moviesAdapter
        }
    }
}