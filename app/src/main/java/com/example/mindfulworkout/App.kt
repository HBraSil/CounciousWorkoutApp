package com.example.mindfulworkout

import android.app.Application
import com.example.mindfulworkout.data.AppDatabase

class App : Application() {
    // inicializar depois
    lateinit var db: AppDatabase

    override fun onCreate() {
        super.onCreate()
        db = AppDatabase.getInstance(this)
    }
}