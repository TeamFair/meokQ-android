package com.meokq.presentation.base

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import com.meokq.presentation.theme.MeokQTheme

abstract class BaseComposeActivity<R : BaseViewModel> : ComponentActivity() {

    abstract val viewModel: R

    abstract fun beforeCompose()

    @Composable
    abstract fun Compose()

    abstract fun afterCompose()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        beforeCompose()
        setContent {
            MeokQTheme {
                Compose()
            }
        }
        afterCompose()
    }
}