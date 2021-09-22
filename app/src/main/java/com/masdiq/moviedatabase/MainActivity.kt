package com.masdiq.moviedatabase

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.masdiq.moviedatabase.models.Movie
import com.masdiq.moviedatabase.service.MovieApiInterface
import com.masdiq.moviedatabase.service.MovieApiService
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var movieAdapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv_movies_list.layoutManager = LinearLayoutManager(this)
        getMovieData { movies: List<Movie> ->
            movieAdapter = MovieAdapter(movies)
            rv_movies_list.adapter = movieAdapter
            // Move with intent
            movieAdapter.onClickItem = {
                val move = Intent(this, DetailActivity::class.java)
                move.putExtra(DetailActivity.EXTRA, it)
                startActivity(move)
            }
        }
        rv_movies_list.setHasFixedSize(true)
    }

    private fun getMovieData(callback: (List<Movie>) -> Unit) {
        val apiService = MovieApiService.getInstance().create(MovieApiInterface::class.java)
        apiService.getMovieList().enqueue(object : Callback<MovieResponse> {
            override fun onResponse(p0: Call<MovieResponse>, p1: Response<MovieResponse>) {
                return callback(p1.body()?.movies!!)
            }

            override fun onFailure(p0: Call<MovieResponse>, p1: Throwable) {
            }
        })
    }
}