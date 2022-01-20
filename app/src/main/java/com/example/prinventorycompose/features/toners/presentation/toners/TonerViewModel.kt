package com.example.prinventorycompose.features.toners.presentation.toners

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.prinventorycompose.features.toners.domain.use_cases.GetTonersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TonerViewModel @Inject constructor(
    private val getTonersUseCase: GetTonersUseCase) : ViewModel() {

    private val _state = mutableStateOf(TonersState())
    val state: State<TonersState> = _state

    init {
        getToners()
    }

    private fun getToners() {
        viewModelScope.launch {
            getTonersUseCase.invoke().collect { toners ->
                _state.value = state.value.copy(
                    toners = toners
                )
            }
        }
    }

}