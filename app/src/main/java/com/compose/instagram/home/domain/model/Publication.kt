package com.compose.instagram.home.domain.model

import androidx.annotation.DrawableRes

data class Publication(
    val userName: String,
    @DrawableRes val userPicture: Int,
    val localisation: String? = null,
    val content: List<String>,
    val likes: Int,
    val description: String,
    val comments: List<String> = emptyList()
)
