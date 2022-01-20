package com.example.prinventorycompose.features.printers.presentation.printers

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.prinventorycompose.features.printers.domain.use_cases.GetPrintersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PrinterViewModel @Inject constructor(
    private val getPrintersUseCase: GetPrintersUseCase) : ViewModel() {

    private val _state = mutableStateOf(PrintersState())
    val state: State<PrintersState> = _state

    init {
        getPrinters()
    }

    private fun getPrinters() {
        viewModelScope.launch {
            getPrintersUseCase.invoke().collect { printers ->
                _state.value = state.value.copy(
                    printers = printers
                )
            }
        }
    }

}