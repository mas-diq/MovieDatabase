package com.masdiq.moviedatabase.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie(
    @SerializedName("id")
    var id: String? = "",

    @SerializedName("title")
    var title: String? = "",

    @SerializedName("poster_path")
    var poster: String? = "",

    @SerializedName("release_date")
    var release: String? = "",

    @SerializedName("popularity")
    var popularity: String? = "",

    @SerializedName("vote_average")
    var voteAverage: String? = "",

    @SerializedName("vote_count")
    var voteCount: String? = "",

    @SerializedName("overview")
    var overview: String? = ""

) : Parcelable {
    constructor() : this("", "", "", "", "", "", "", "")
}