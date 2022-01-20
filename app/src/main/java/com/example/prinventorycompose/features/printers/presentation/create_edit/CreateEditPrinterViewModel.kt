package com.example.prinventorycompose.features.printers.presentation.create_edit

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.prinventorycompose.features.common.TextFieldState
import com.example.prinventorycompose.features.printers.domain.model.Printer
import com.example.prinventorycompose.features.printers.domain.use_cases.AddPrinterUseCase
import com.example.prinventorycompose.features.printers.domain.use_cases.DeletePrinterUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CreateEditPrinterViewModel @Inject constructor(
    private val addPrinterUseCase: AddPrinterUseCase,
    private val deletePrinterUseCase: DeletePrinterUseCase) : ViewModel() {

    private val _make = mutableStateOf(TextFieldState())
    val make: State<TextFieldState> = _make

    private val _model = mutableStateOf(TextFieldState())
    val model: State<TextFieldState> = _model

    private val _serial = mutableStateOf(TextFieldState())
    val serial: State<TextFieldState> = _serial

    private val _owner = mutableStateOf(TextFieldState())
    val owner: State<TextFieldState> = _owner

    private val _dept = mutableStateOf(TextFieldState())
    val dept: State<TextFieldState> = _dept

    private val _location = mutableStateOf(TextFieldState())
    val location: State<TextFieldState> = _location

    private val _floor = mutableStateOf(TextFieldState())
    val floor: State<TextFieldState> = _floor

    private val _ip = mutableStateOf(TextFieldState())
    val ip: State<TextFieldState> = _ip

    private var editId: Int? = null

    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    fun populateFields(printer: Printer){
        editId = printer.id

        _make.value = make.value.copy(
            text = printer.make.toString(),
        )

        _model.value = model.value.copy(
            text = printer.model.toString(),
        )

        _serial.value = serial.value.copy(
            text = printer.serial.toString(),
        )

        _owner.value = owner.value.copy(
            text = printer.owner.toString(),
        )

        _dept.value = dept.value.copy(
            text = printer.dept.toString(),
        )

        _location.value = location.value.copy(
            text = printer.location.toString(),
        )

        _floor.value = floor.value.copy(
            text = printer.floor.toString(),
        )

        _ip.value = ip.value.copy(
            text = printer.ip.toString(),
        )
    }

    fun onEvent(event: CreateEditPrinterEvent) {
        when(event) {
            is CreateEditPrinterEvent.CreatePrinter -> {
                viewModelScope.launch {
                    addPrinterUseCase.invoke(
                        if(editId == null){
                            Printer(
                                make = make.value.text,
                                model = model.value.text,
                                serial = serial.value.text,
                                owner = owner.value.text,
                                dept = dept.value.text,
                                location = location.value.text,
                                floor = floor.value.text,
                                ip = ip.value.text
                            )
                        }else{
                            Printer(
                                id = editId,
                                make = make.value.text,
                                model = model.value.text,
                                serial = serial.value.text,
                                owner = owner.value.text,
                                dept = dept.value.text,
                                location = location.value.text,
                                floor = floor.value.text,
                                ip = ip.value.text
                            )
                        }
                    )
                    _eventFlow.emit(UiEvent.CreatePrinter)
                }
            }

            is CreateEditPrinterEvent.DeletePrinter -> {
                viewModelScope.launch {
                    deletePrinterUseCase.invoke(event.printer)
                    _eventFlow.emit(UiEvent.DeletePrinter)
                }
            }

            is CreateEditPrinterEvent.OnEnteredMake -> {
                _make.value = make.value.copy(
                    text = event.value
                )
            }

            is CreateEditPrinterEvent.OnEnteredModel -> {
                _model.value = model.value.copy(
                    text = event.value
                )
            }

            is CreateEditPrinterEvent.OnEnteredSerial -> {
                _serial.value = serial.value.copy(
                    text = event.value
                )
            }

            is CreateEditPrinterEvent.OnEnteredOwner -> {
                _owner.value = owner.value.copy(
                    text = event.value
                )
            }

            is CreateEditPrinterEvent.OnEnteredDept -> {
                _dept.value = dept.value.copy(
                    text = event.value
                )
            }

            is CreateEditPrinterEvent.OnEnteredLocation -> {
                _location.value = location.value.copy(
                    text = event.value
                )
            }

            is CreateEditPrinterEvent.OnEnteredFloor -> {
                _floor.value = floor.value.copy(
                    text = event.value
                )
            }

            is CreateEditPrinterEvent.OnEnteredIP -> {
                _ip.value = ip.value.copy(
                    text = event.value
                )
            }

        }
    }

    sealed class UiEvent {
        object CreatePrinter: UiEvent()
        object DeletePrinter: UiEvent()
    }

}