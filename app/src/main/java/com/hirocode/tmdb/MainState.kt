package com.hirocode.tmdb

import com.hirocode.tmdb.domain.model.Movies

sealed class MainState {
    object Loading : MainState()
    data class Success(val data: List<Movies>) : MainState()
    data class Error(val message: String) : MainState()
}