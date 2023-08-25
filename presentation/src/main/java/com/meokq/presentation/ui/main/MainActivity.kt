package com.meokq.presentation.ui.main

import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.meokq.presentation.base.BaseComposeActivity
import com.meokq.presentation.ui.nav.BottomNavigationBar
import com.meokq.presentation.ui.nav.BottomNavigationItem
import com.meokq.presentation.ui.nav.MainNavHost
import com.meokq.presentation.ui.nav.MeokQDestination
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainComposeActivity : BaseComposeActivity<MainViewModel>() {
    override val viewModel: MainViewModel by viewModels()

    override fun beforeCompose() {
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun Compose() {
        val navController = rememberNavController()

        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route ?: MeokQDestination.QUEST_ROUTE

        Scaffold(bottomBar = {
            BottomNavigationBar(
                selectedItemPosition = when (currentRoute) {
                    MeokQDestination.QUEST_ROUTE -> 0
                    MeokQDestination.COUPON_ROUTE -> 1
                    else -> 0
                }, { selectedItemPosition ->
                    when (selectedItemPosition) {
                        0 -> navController.navigate(MeokQDestination.QUEST_ROUTE)
                        1 -> navController.navigate(MeokQDestination.COUPON_ROUTE)
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.surface),
                listOf(
                    BottomNavigationItem("Quest", Icons.Default.Star),
                    BottomNavigationItem("Coupon", Icons.Default.List)
                )
            )
        }) {
            Box(modifier = Modifier.padding(it)) {
                MainNavHost(navController)
            }
        }
    }

    override fun afterCompose() {
    }
}