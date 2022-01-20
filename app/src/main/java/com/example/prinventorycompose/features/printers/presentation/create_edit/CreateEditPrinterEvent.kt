package com.example.prinventorycompose.features.printers.presentation.create_edit

import com.example.prinventorycompose.features.printers.domain.model.Printer

sealed class CreateEditPrinterEvent{

    data class OnEnteredMake(val value: String): CreateEditPrinterEvent()
    data class OnEnteredModel(val value: String): CreateEditPrinterEvent()
    data class OnEnteredSerial(val value: String): CreateEditPrinterEvent()
    data class OnEnteredOwner(val value: String): CreateEditPrinterEvent()
    data class OnEnteredDept(val value: String): CreateEditPrinterEvent()
    data class OnEnteredLocation(val value: String): CreateEditPrinterEvent()
    data class OnEnteredFloor(val value: String): CreateEditPrinterEvent()
    data class OnEnteredIP(val value: String): CreateEditPrinterEvent()

    object CreatePrinter: CreateEditPrinterEvent()
    data class DeletePrinter(val printer: Printer): CreateEditPrinterEvent()
}