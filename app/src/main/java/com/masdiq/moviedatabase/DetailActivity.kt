package com.masdiq.moviedatabase

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.masdiq.moviedatabase.models.Movie
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    private var data: Movie? = null

    companion object {
        const val EXTRA = "extra"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        data = intent.getParcelableExtra(EXTRA)

        if (data != null) {
            val IMAGE_BASE = "https://image.tmdb.org/t/p/w500/"
            Glide.with(this)
                .load(IMAGE_BASE + data?.poster)
                .apply(RequestOptions())
                .into(movie_poster_detail)
            movie_title_detail.text = data?.title
            movie_release_date_detail.text = data?.release
            movie_popularity_detail.text = data?.popularity
            movie_vote_detail.text = data?.voteAverage
        }
    }
}