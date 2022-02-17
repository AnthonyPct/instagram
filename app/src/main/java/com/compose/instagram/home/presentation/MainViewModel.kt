package com.compose.instagram.home.presentation

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.compose.instagram.base.BaseViewModel
import com.compose.instagram.home.data.HomeRepository
import com.compose.instagram.home.data.IHomeRepository
import com.compose.instagram.home.domain.model.Story
import com.compose.instagram.home.domain.usecase.GetStoriesUseCase
import kotlinx.coroutines.launch
import toothpick.InjectConstructor
import toothpick.config.Module
import toothpick.ktp.binding.bind
import toothpick.ktp.binding.module
import javax.inject.Inject

@InjectConstructor
class MainViewModel(application: Application) :
    BaseViewModel(application),
    IMainContract.ViewModel {

    ///////////////////////////////////////////////////////////////////////////
    // CONFIGURATION
    ///////////////////////////////////////////////////////////////////////////

    override val viewModelInjectionModule: Module
        get() = module {
            bind<IHomeRepository>().toClass<HomeRepository>().singleton()
        }

    ///////////////////////////////////////////////////////////////////////////
    // DEPENDENCY
    ///////////////////////////////////////////////////////////////////////////

    @Inject
    lateinit var getStoriesUseCase: GetStoriesUseCase

    ///////////////////////////////////////////////////////////////////////////
    // DATA
    ///////////////////////////////////////////////////////////////////////////

    private val _stories = MutableLiveData(listOf<Story>())

    ///////////////////////////////////////////////////////////////////////////
    // LIFECYCLE
    ///////////////////////////////////////////////////////////////////////////

    override fun onCreated() {
        getStories()
    }

    ///////////////////////////////////////////////////////////////////////////
    // CONTRACT
    ///////////////////////////////////////////////////////////////////////////

    override val stories: LiveData<List<Story>>
        get() = _stories

    override fun getStories() {
        viewModelScope.launch {
            val stories = getStoriesUseCase.execute()
            _stories.postValue(stories)
        }
    }

    override fun updateStory() {
        viewModelScope.launch {
            val stories = getStoriesUseCase.execute().shuffled()
            _stories.postValue(stories)
        }
    }
}