package com.example.gitapiapprmk.domain

sealed class GitRepoState<out T> {
    class Success<T>(val data: T) : GitRepoState<T>()
    object Loading : GitRepoState<Nothing>()
    object Error : GitRepoState<Nothing>()
    object EmptyList : GitRepoState<Nothing>()
}