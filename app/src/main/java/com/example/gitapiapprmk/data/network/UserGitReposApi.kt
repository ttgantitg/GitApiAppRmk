package com.example.gitapiapprmk.data.network

import com.example.gitapiapprmk.data.dto.UserGitReposDto
import retrofit2.http.GET
import retrofit2.http.Path

interface UserGitReposApi {

    @GET("users/{user}/repos")
    suspend fun getUserRepos(@Path("user", encoded = true) user: String): List<UserGitReposDto>
}