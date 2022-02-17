package com.compose.instagram.home.domain.model

import androidx.annotation.DrawableRes

data class Story(
    val id: Int,
    val userName: String,
    @DrawableRes val picture: Int,
    val isRead: Boolean,
    val content: List<String>
)