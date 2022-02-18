package com.compose.instagram.home.presentation

import androidx.lifecycle.LiveData
import com.compose.instagram.home.domain.model.Publication
import com.compose.instagram.home.domain.model.Story

interface IMainContract {

    interface ViewModel {
        val stories: LiveData<List<Story>>
        val publications: LiveData<List<Publication>>
        fun getStories() {}
        fun updateStory() {}
        fun getPublications()
    }

    interface ViewEvent {
        interface AppBar {
            fun onClickMessage() {}
        }
    }
}