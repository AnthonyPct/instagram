package com.compose.instagram.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

fun <T : ViewModel> BaseActivity.getViewModel(viewModelClass: Class<T>): T =
    ViewModelProvider(this).get(viewModelClass)
