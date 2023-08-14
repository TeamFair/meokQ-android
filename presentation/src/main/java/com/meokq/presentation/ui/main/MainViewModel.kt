package com.meokq.presentation.ui.main

import android.util.Log
import androidx.compose.runtime.MutableState
import com.meokq.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import usecase.GetCurrentUserIdUseCase
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(getCurrentUserIdUseCase: GetCurrentUserIdUseCase) :
    BaseViewModel() {

    lateinit var test : String

    init {
        test = getCurrentUserIdUseCase()
    }
}