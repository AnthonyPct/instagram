package com.compose.instagram.base

import android.app.Application
import toothpick.ktp.KTP

class InstagramApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        KTP.openScope(this)
            .inject(this)
    }
}