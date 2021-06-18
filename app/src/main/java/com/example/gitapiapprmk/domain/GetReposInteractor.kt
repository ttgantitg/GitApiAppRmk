package com.example.gitapiapprmk.domain

import com.example.gitapiapprmk.data.dto.UserGitReposDto
import com.example.gitapiapprmk.data.network.UserGitReposApi
import javax.inject.Inject

interface GetReposInteractor {
    suspend fun getUserRepos(user: String): List<UserGitReposDto>
}

class GetReposInteractorImpl @Inject constructor(private val userGitReposApi: UserGitReposApi) : GetReposInteractor {
    override suspend fun getUserRepos(user: String): List<UserGitReposDto> =
        userGitReposApi.getUserRepos(user)
}