package com.example.prinventorycompose

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
open class PrinventoryApplication: Application() {

    override fun onCreate() {
        super.onCreate()
    }

}