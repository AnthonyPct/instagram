package com.compose.instagram.base

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.compose.instagram.ui.theme.InstagramTheme
import toothpick.config.Module
import toothpick.ktp.KTP
import toothpick.smoothie.lifecycle.closeOnDestroy
import toothpick.smoothie.module.SmoothieAndroidXActivityModule

abstract class BaseActivity : ComponentActivity() {

    ///////////////////////////////////////////////////////////////////////////
    // ABSTRACT
    ///////////////////////////////////////////////////////////////////////////

    @Composable
    abstract fun GetContent()

    open val activityModule: Module = Module()

    ///////////////////////////////////////////////////////////////////////////
    // LIFECYCLE
    ///////////////////////////////////////////////////////////////////////////

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectDependencies()
        setContent {
            InstagramTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) { GetContent() }
            }
        }
    }

    private fun injectDependencies() {
        KTP.openRootScope()
            .openSubScope(this)
            .installModules(activityModule)
            .closeOnDestroy(this)
            .inject(this)
    }
}