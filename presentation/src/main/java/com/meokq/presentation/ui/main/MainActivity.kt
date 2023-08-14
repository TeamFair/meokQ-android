package com.meokq.presentation.ui.main

import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.meokq.presentation.base.BaseComposeActivity
import com.meokq.presentation.theme.MeokQTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainComposeActivity : BaseComposeActivity<MainViewModel>() {
    override val viewModel: MainViewModel by viewModels()

    override fun beforeCompose() {
    }

    @Composable
    override fun Compose() {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Greeting(viewModel.test)
        }
    }

    override fun afterCompose() {
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MeokQTheme {
        Greeting("Android")
    }
}