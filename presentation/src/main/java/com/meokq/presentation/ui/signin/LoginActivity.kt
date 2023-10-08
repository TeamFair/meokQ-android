package com.meokq.presentation.ui.signin

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import com.meokq.presentation.base.BaseComposeActivity
import com.meokq.presentation.ui.main.MainComposeActivity

class LoginActivity:BaseComposeActivity<LoginViewModel>() {
    override val viewModel: LoginViewModel by viewModels()

    override fun beforeCompose() {
    }

    @Composable
    override fun Compose() {
        LoginScreen(
            onNavigate={
                this.startActivity(Intent(this@LoginActivity, MainComposeActivity::class.java))
            }
        )
    }

    override fun afterCompose() {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

}