package com.compose.instagram.home.presentation

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import com.compose.instagram.base.BaseActivity
import com.compose.instagram.home.presentation.composable.HomeScreen
import com.compose.instagram.splash.presentation.SplashScreen
import com.compose.instagram.splash.presentation.SplashState
import toothpick.config.Module
import javax.inject.Inject

class MainActivity :
    BaseActivity(),
    IMainContract.ViewEvent.AppBar {

    ///////////////////////////////////////////////////////////////////////////
    // CONFIGURATION
    ///////////////////////////////////////////////////////////////////////////

    override val activityModule: Module
        get() = MainActivityModule(this)

    ///////////////////////////////////////////////////////////////////////////
    // DEPENDENCIES
    ///////////////////////////////////////////////////////////////////////////

    @Inject
    lateinit var mainViewModel: IMainContract.ViewModel

    ///////////////////////////////////////////////////////////////////////////
    // COMPOSABLE
    ///////////////////////////////////////////////////////////////////////////

    @Composable
    override fun GetContent() {
        Surface(color = MaterialTheme.colors.primary) {
            var state by remember { mutableStateOf(SplashState.Shown) }
            if (state == SplashState.Shown) {
                SplashScreen {
                    state = SplashState.Completed
                }
            } else {
                HomeScreen(mainViewModel, this)
            }
        }
    }

    ///////////////////////////////////////////////////////////////////////////
    // EVENTS
    ///////////////////////////////////////////////////////////////////////////

    override fun onClickMessage() {
        mainViewModel.updateStory()
    }
}

