package com.hirocode.tmdb.data.source.service

import com.hirocode.tmdb.BuildConfig.API_KEY
import com.hirocode.tmdb.data.source.response.MoviesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesService {
    @GET("movie/popular")
    suspend fun getPopular(
        @Query("api_key") apiKey: String = API_KEY,
    ): MoviesResponse
}