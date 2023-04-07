package com.hirocode.tmdb.data.source.response

import com.google.gson.annotations.SerializedName

data class MoviesResponse(
	@field:SerializedName("results")
	val results: List<ResultsItem>,
)