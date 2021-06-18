package com.example.gitapiapprmk.data.dto

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class UserGitReposDto (
    @SerializedName("name") val userRepo: String = ""
)