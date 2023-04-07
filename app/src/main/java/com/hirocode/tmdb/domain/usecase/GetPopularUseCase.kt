package com.hirocode.tmdb.domain.usecase

import com.hirocode.tmdb.domain.model.Movies
import com.hirocode.tmdb.domain.repository.MoviesRepository
import kotlinx.coroutines.flow.Flow

class GetPopularUseCase(private val moviesRepository: MoviesRepository) {
    operator fun invoke(): Flow<List<Movies>> {
        return moviesRepository.getPopular()
    }
}