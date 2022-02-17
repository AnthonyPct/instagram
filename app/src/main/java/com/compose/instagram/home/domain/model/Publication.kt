package com.compose.instagram.home.domain.model

data class Publication(
    val userName: String,
    val localisation: String? = null,
    val content: List<String>,
    val likes: Int,
    val description: String
)
