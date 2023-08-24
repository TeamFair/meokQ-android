package com.meokq.presentation.ui.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.meokq.presentation.ui.coupon.CouponScreen
import com.meokq.presentation.ui.quest.QuestScreen

@Composable
fun MainNavHost(navController : NavHostController = rememberNavController()) {
    NavHost(navController = navController, startDestination = MeokQDestination.QUEST_ROUTE) {
        composable(MeokQDestination.QUEST_ROUTE) {
            QuestScreen()
        }
        composable(MeokQDestination.COUPON_ROUTE) {
            CouponScreen()
        }
    }
}