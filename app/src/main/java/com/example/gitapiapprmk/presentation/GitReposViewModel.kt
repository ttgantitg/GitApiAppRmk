package com.example.gitapiapprmk.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gitapiapprmk.data.dto.UserGitReposDto
import com.example.gitapiapprmk.domain.GetReposInteractor
import com.example.gitapiapprmk.domain.GitRepoState
import kotlinx.coroutines.launch
import javax.inject.Inject

class GitReposViewModel @Inject constructor(private val getReposInteractor: GetReposInteractor) : ViewModel() {

    var gitReposState: MutableLiveData<GitRepoState<List<UserGitReposDto>>> = MutableLiveData()

    fun loadUserGitRepos(user: String): MutableLiveData<GitRepoState<List<UserGitReposDto>>>  {
        gitReposState.value = GitRepoState.Loading
        viewModelScope.launch {
            try {
                getReposInteractor.getUserRepos(user).apply {
                    gitReposState.value = if (isEmpty()) GitRepoState.EmptyList else GitRepoState.Success(this)
                }
            } catch (e: Exception) {
                gitReposState.value = GitRepoState.Error
            }
        }
        return gitReposState
    }
}