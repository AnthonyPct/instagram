package com.compose.instagram.home.data

import com.compose.instagram.home.domain.model.Publication
import com.compose.instagram.home.domain.model.Story

interface IHomeRepository {
    suspend fun getStories() : List<Story>
    suspend fun getPublications(): List<Publication>
}