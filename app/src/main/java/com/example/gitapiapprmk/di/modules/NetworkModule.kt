package com.example.gitapiapprmk.di.modules

import com.example.gitapiapprmk.data.network.UserGitReposApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module(includes = [ViewModelModule::class])
class NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://api.github.com/")
            .build()
    }

    @Provides
    @Singleton
    fun provideGithubService(retrofit: Retrofit): UserGitReposApi {
        return retrofit.create(UserGitReposApi::class.java)
    }
}