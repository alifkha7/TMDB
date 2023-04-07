package com.hirocode.tmdb.data.source

import com.hirocode.tmdb.data.source.response.MoviesResponse

interface MoviesDataSource {
    suspend fun getPopular(): MoviesResponse
}