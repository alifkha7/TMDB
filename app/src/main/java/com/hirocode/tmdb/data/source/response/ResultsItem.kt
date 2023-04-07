package com.hirocode.tmdb.data.source.response

import com.google.gson.annotations.SerializedName
import com.hirocode.tmdb.domain.model.Movies

data class ResultsItem(
	@field:SerializedName("overview")
	val overview: String,

	@field:SerializedName("title")
	val title: String,

	@field:SerializedName("poster_path")
	val posterPath: String,
)

fun ResultsItem.toMovies(): Movies {
	return Movies(
		overview = overview,
		title = title,
		posterPath = posterPath,
	)
}