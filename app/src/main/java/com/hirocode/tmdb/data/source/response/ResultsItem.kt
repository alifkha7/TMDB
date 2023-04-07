package com.hirocode.tmdb.data.source.response

import com.google.gson.annotations.SerializedName

data class ResultsItem(
	@field:SerializedName("overview")
	val overview: String,

	@field:SerializedName("title")
	val title: String,

	@field:SerializedName("poster_path")
	val posterPath: String,
)