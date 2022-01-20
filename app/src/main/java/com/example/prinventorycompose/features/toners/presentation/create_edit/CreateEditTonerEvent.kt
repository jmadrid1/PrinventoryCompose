package com.example.prinventorycompose.features.toners.presentation.create_edit

import com.example.prinventorycompose.features.toners.domain.model.Toner

sealed class CreateEditTonerEvent{
    data class OnEnteredMake(val value: String): CreateEditTonerEvent()
    data class OnEnteredModel(val value: String): CreateEditTonerEvent()
    data class OnEnteredTonerModel(val value: String): CreateEditTonerEvent()
    data class OnEnteredBlack(val value: String): CreateEditTonerEvent()
    data class OnEnteredCyan(val value: String): CreateEditTonerEvent()
    data class OnEnteredYellow(val value: String): CreateEditTonerEvent()
    data class OnEnteredMagenta(val value: String): CreateEditTonerEvent()

    object CreateToner: CreateEditTonerEvent()
    data class DeleteToner(val toner: Toner): CreateEditTonerEvent()

}