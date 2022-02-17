package com.compose.instagram.home.presentation

import androidx.lifecycle.LiveData
import com.compose.instagram.home.domain.model.Story

interface IMainContract {

    interface ViewModel {
        val stories: LiveData<List<Story>>
        fun getStories() {}
        fun updateStory() {}
    }

    interface ViewEvent {
        interface AppBar {
            fun onClickMessage() {}
        }
    }
}