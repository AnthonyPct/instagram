package com.compose.instagram.home.presentation

import com.compose.instagram.base.getViewModel
import toothpick.config.Module
import toothpick.ktp.binding.bind

class MainActivityModule(activity: MainActivity) : Module() {
    init {
        // General
        bind<MainActivity>().toInstance(activity)
        bind<IMainContract.ViewModel>().toInstance(activity.getViewModel(MainViewModel::class.java))
//        bind<IMainContract.ViewNavigation>().toClass<MainNavigator>().singleton()
    }
}
