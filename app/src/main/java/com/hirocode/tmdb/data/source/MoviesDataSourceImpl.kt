package com.hirocode.tmdb.data.source

import com.hirocode.tmdb.data.source.response.MoviesResponse
import com.hirocode.tmdb.data.source.service.MoviesService

class MoviesDataSourceImpl(private val moviesService: MoviesService): MoviesDataSource {
    override suspend fun getPopular(): MoviesResponse {
        return moviesService.getPopular()
    }
}