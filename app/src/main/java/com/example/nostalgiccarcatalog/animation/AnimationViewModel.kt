package com.example.nostalgiccarcatalog.animation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnimationViewModel @Inject constructor(): ViewModel(){
    private val _isRefreshing = MutableStateFlow(false)

    val isRefreshing: StateFlow<Boolean>
        get() = _isRefreshing.asStateFlow()

    fun refresh() {
        // This doesn't handle multiple 'refreshing' tasks, don't use this
        viewModelScope.launch {
            // A fake 2 second 'refresh'
            _isRefreshing.emit(true)

            delay(1000)
            _isRefreshing.emit(false)

        }
    }
}