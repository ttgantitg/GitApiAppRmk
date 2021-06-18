package com.example.gitapiapprmk.di.components

import com.example.gitapiapprmk.presentation.MainActivity
import com.example.gitapiapprmk.di.modules.ContextModule
import com.example.gitapiapprmk.di.modules.GitReposInteractorModule
import com.example.gitapiapprmk.di.modules.NetworkModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    NetworkModule::class,
    ContextModule::class,
    GitReposInteractorModule::class])
interface AppComponent {
    fun inject(mainActivity: MainActivity?)
}