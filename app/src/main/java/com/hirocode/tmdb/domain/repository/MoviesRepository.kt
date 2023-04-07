package com.hirocode.tmdb.domain.repository

import com.hirocode.tmdb.domain.model.Movies
import kotlinx.coroutines.flow.Flow

interface MoviesRepository {
    fun getPopular(): Flow<List<Movies>>
}