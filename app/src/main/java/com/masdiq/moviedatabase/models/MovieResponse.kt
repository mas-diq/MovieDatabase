package com.masdiq.moviedatabase

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.masdiq.moviedatabase.models.Movie
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieResponse(
    @SerializedName("results")
    val movies: List<Movie>
) : Parcelable {
    constructor() : this(mutableListOf())
}