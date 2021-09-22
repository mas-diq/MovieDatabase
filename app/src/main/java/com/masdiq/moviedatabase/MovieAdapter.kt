package com.masdiq.moviedatabase

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.masdiq.moviedatabase.models.Movie
import kotlinx.android.synthetic.main.movie_item.view.*

class MovieAdapter(
    private val movies: List<Movie>,
) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    var onClickItem: ((Movie) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val listView =
            LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false)
        return MovieViewHolder(listView)
    }

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val IMAGE_BASE = "https://image.tmdb.org/t/p/w500/"
        val item = movies[position]
        Glide.with(holder.itemView.context)
            .load(IMAGE_BASE + item.poster)
            .apply(RequestOptions())
            .into(holder.image)
        holder.title.text = item.title
        holder.release.text = item.release
        holder.popularity.text = item.popularity + " Peoples"
        holder.vote.text = item.voteAverage + " Out of 10"
    }

    inner class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image = view.movie_poster!!
        val title = view.movie_title!!
        val release = view.movie_release_date!!
        val popularity = view.movie_popularity!!
        val vote = view.movie_vote!!

        init {
            itemView.setOnClickListener {
                onClickItem?.invoke(movies[adapterPosition])
            }
        }
    }
}