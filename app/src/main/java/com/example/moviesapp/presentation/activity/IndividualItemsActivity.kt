package com.example.moviesapp.presentation.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.moviesapp.databinding.ActivityIndividualItemsBinding
import kotlinx.android.synthetic.main.individual_movies_layout.view.*

class IndividualItemsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityIndividualItemsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityIndividualItemsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        val id = intent.getStringExtra("id")
        val title = intent.getStringExtra("title")
        val image = intent.getStringExtra("image")
        val type = intent.getStringExtra("type")
        val year = intent.getStringExtra("year")

        binding.id.text =id
        binding.title.text = title
        binding.type.text = type
        binding.year.text = year
       // binding.image.imageAlpha = image.
        val imageHolder = binding.image


        Glide.with(this)
            .load(image)
            .into(imageHolder)
    }
}