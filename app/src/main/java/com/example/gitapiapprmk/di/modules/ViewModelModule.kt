package com.example.gitapiapprmk.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.gitapiapprmk.di.ViewModelFactory
import com.example.gitapiapprmk.di.ViewModelKey
import com.example.gitapiapprmk.presentation.GitReposViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(GitReposViewModel::class)
    abstract fun bindViewModel(gitReposViewModel: GitReposViewModel?): ViewModel?

    @Binds
    abstract fun bindFactory(factory: ViewModelFactory?): ViewModelProvider.Factory?
}