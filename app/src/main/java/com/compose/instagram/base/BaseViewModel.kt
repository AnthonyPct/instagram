package com.compose.instagram.base

import android.app.Application
import androidx.annotation.CallSuper
import androidx.lifecycle.AndroidViewModel
import toothpick.config.Module
import toothpick.ktp.KTP

abstract class BaseViewModel(application: Application) : AndroidViewModel(application) {

    ////////////////////////////////////////////////////////////////////////////////////////////////////
    // DEPENDENCIES
    ////////////////////////////////////////////////////////////////////////////////////////////////////

    open val viewModelInjectionModule: Module = Module()

    ////////////////////////////////////////////////////////////////////////////////////////////////////
    // CONSTRUCTOR
    ////////////////////////////////////////////////////////////////////////////////////////////////////

    init {
        KTP.openRootScope()
            .openSubScope(this)
            .installModules(viewModelInjectionModule)
            .inject(this)

        onCreated()
    }


    ////////////////////////////////////////////////////////////////////////////////////////////////////
    // LIFE CYCLE
    ////////////////////////////////////////////////////////////////////////////////////////////////////

    @CallSuper
    override fun onCleared() {
        KTP.closeScope(this)
        super.onCleared()
    }

    open fun onCreated() {}
}