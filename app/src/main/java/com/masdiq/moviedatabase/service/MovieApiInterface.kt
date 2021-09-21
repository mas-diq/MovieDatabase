package com.masdiq.moviedatabase.service

import com.masdiq.moviedatabase.MovieResponse
import retrofit2.Call
import retrofit2.http.GET

interface MovieApiInterface {
    @GET("movie/popular?api_key=8f2f06ece6c7d9dfd834ab0a1dbd3bc5")
    fun getMovieList(): Call<MovieResponse>
}