package com.hirocode.tmdb

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hirocode.tmdb.domain.usecase.GetPopularUseCase
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class MainViewModel(private val getPopularUseCase: GetPopularUseCase): ViewModel() {
    private val _mainState = MutableStateFlow<MainState>(MainState.Loading)
    val mainState: StateFlow<MainState> = _mainState.asStateFlow()

    init {
        getPopular()
    }

    private fun getPopular() {
        viewModelScope.launch {
            getPopularUseCase.invoke()
                .onStart {
                    _mainState.value = MainState.Loading
                }.catch {
                    _mainState.value = MainState.Error(it.localizedMessage ?: "Couldn't reach server. Check your internet connection")
                }.collectLatest { data ->
                    _mainState.value = MainState.Success(data)
                }
        }
    }
}