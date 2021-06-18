package com.example.gitapiapprmk

import android.app.Application
import com.example.gitapiapprmk.di.components.AppComponent
import com.example.gitapiapprmk.di.components.DaggerAppComponent

class App : Application() {
    private var appComponent: AppComponent? = null

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.create()
    }

    fun getComponent(): AppComponent? {
        return appComponent
    }
}