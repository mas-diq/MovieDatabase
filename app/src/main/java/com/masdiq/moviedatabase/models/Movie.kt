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

    @field:SerializedName("popularity")
    var popularity: String? = "",

    @field:SerializedName("vote_average")
    var voteAverage: String? = ""

) : Parcelable {
    constructor() : this("", "", "", "", "", "")
}