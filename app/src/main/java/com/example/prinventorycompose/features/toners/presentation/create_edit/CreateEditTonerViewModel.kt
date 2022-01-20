package com.example.prinventorycompose.features.toners.presentation.create_edit

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.prinventorycompose.features.common.TextFieldState
import com.example.prinventorycompose.features.toners.domain.model.Toner
import com.example.prinventorycompose.features.toners.domain.use_cases.AddTonerUseCase
import com.example.prinventorycompose.features.toners.domain.use_cases.DeleteTonerUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CreateEditTonerViewModel @Inject constructor(
    private val addTonerUseCase: AddTonerUseCase,
    private val deleteTonerUseCase: DeleteTonerUseCase) : ViewModel() {

    private val _make = mutableStateOf(TextFieldState())
    val make: State<TextFieldState> = _make

    private val _model = mutableStateOf(TextFieldState())
    val model: State<TextFieldState> = _model

    private val _tonerModel = mutableStateOf(TextFieldState())
    val tonerModel: State<TextFieldState> = _tonerModel

    private val _black = mutableStateOf(TextFieldState(text = "0"))
    val black: State<TextFieldState> = _black

    private val _cyan = mutableStateOf(TextFieldState(text = "0"))
    val cyan: State<TextFieldState> = _cyan

    private val _yellow = mutableStateOf(TextFieldState(text = "0"))
    val yellow: State<TextFieldState> = _yellow

    private val _magenta = mutableStateOf(TextFieldState(text = "0"))
    val magenta: State<TextFieldState> = _magenta

    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    private var editId: Int? = null

    fun populateFields(toner: Toner){
        editId = toner.id

        _make.value = make.value.copy(
            text = toner.make.toString(),
        )

        _model.value = model.value.copy(
            text = toner.model.toString(),
        )

        _tonerModel.value = tonerModel.value.copy(
            text = toner.tonerModel.toString(),
        )

        _black.value = black.value.copy(
            text = toner.black.toString(),
        )

        _cyan.value = cyan.value.copy(
            text = toner.cyan.toString(),
        )

        _yellow.value = yellow.value.copy(
            text = toner.yellow.toString(),
        )

        _magenta.value = magenta.value.copy(
            text = toner.magenta.toString(),
        )
    }

    fun onEvent(event: CreateEditTonerEvent) {
        when(event) {
            is CreateEditTonerEvent.CreateToner -> {
                viewModelScope.launch {
                    addTonerUseCase.invoke(
                        if(editId == null){
                            Toner(
                                make = make.value.text,
                                model = model.value.text,
                                tonerModel = tonerModel.value.text,
                                black = black.value.text.toInt(),
                                cyan = cyan.value.text.toInt(),
                                yellow = yellow.value.text.toInt(),
                                magenta = magenta.value.text.toInt()
                            )
                        }else{
                            Toner(
                                id = editId,
                                make = make.value.text,
                                model = model.value.text,
                                tonerModel = tonerModel.value.text,
                                black = black.value.text.toInt(),
                                cyan = cyan.value.text.toInt(),
                                yellow = yellow.value.text.toInt(),
                                magenta = magenta.value.text.toInt()
                            )
                        }
                    )
                    _eventFlow.emit(UiEvent.CreateToner)
                }
            }

            is CreateEditTonerEvent.DeleteToner -> {
                viewModelScope.launch {
                    deleteTonerUseCase.invoke(event.toner)
                    _eventFlow.emit(UiEvent.DeleteToner)
                }
            }

            is CreateEditTonerEvent.OnEnteredMake -> {
                _make.value = make.value.copy(
                    text = event.value
                )
            }

            is CreateEditTonerEvent.OnEnteredModel -> {
                _model.value = model.value.copy(
                    text = event.value
                )
            }

            is CreateEditTonerEvent.OnEnteredTonerModel -> {
                _tonerModel.value = tonerModel.value.copy(
                    text = event.value
                )
            }

            is CreateEditTonerEvent.OnEnteredBlack -> {
                _black.value = black.value.copy(
                    text = event.value
                )
            }

            is CreateEditTonerEvent.OnEnteredCyan -> {
                _cyan.value = cyan.value.copy(
                    text = event.value
                )
            }

            is CreateEditTonerEvent.OnEnteredYellow -> {
                _yellow.value = yellow.value.copy(
                    text = event.value
                )
            }

            is CreateEditTonerEvent.OnEnteredMagenta -> {
                _magenta.value = magenta.value.copy(
                    text = event.value
                )
            }

        }
    }

    sealed class UiEvent {
        object CreateToner: UiEvent()
        object DeleteToner: UiEvent()
    }
}