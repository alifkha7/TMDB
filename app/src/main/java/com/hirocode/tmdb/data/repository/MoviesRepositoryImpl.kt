package com.hirocode.tmdb.data.repository

import com.hirocode.tmdb.data.source.MoviesDataSource
import com.hirocode.tmdb.data.source.response.toMovies
import com.hirocode.tmdb.domain.model.Movies
import com.hirocode.tmdb.domain.repository.MoviesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class MoviesRepositoryImpl(private val moviesDataSource: MoviesDataSource): MoviesRepository {
    override fun getPopular(): Flow<List<Movies>> {
        return flow {
            emit(moviesDataSource.getPopular().results.map { it.toMovies() })
        }.flowOn(Dispatchers.IO)
    }
}