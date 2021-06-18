package com.example.gitapiapprmk.di.modules

import com.example.gitapiapprmk.domain.GetReposInteractor
import com.example.gitapiapprmk.domain.GetReposInteractorImpl
import dagger.Binds
import dagger.Module

@Module
abstract class GitReposInteractorModule {

    @Binds
    abstract fun provideReposInteractor(getReposInteractor: GetReposInteractorImpl?): GetReposInteractor?
}