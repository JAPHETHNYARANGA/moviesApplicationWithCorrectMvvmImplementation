package com.example.moviesapp.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviesapp.R
import com.example.moviesapp.domain.models.Search
import kotlinx.android.synthetic.main.individual_movies_layout.view.*

class MoviesAdapter() : RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {


    private var items = ArrayList<Search>()

    fun moviesListData(data: ArrayList<Search>){
        this.items = data
    }

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        private var title = itemView.title
        private var image = itemView.image

        fun bind(data: Search){
            title.text = data.Title

            val picture = data.Poster
            Glide.with(image)
                .load(picture)
                .into(image)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val moviesInflator = LayoutInflater.from(parent.context).inflate(R.layout.individual_movies_layout, parent, false)
        return ViewHolder(moviesInflator)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }
}