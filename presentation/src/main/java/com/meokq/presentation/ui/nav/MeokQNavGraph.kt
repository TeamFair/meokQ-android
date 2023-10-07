package com.meokq.presentation.ui.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.meokq.presentation.ui.coupon.CouponScreen
import com.meokq.presentation.ui.quest.QuestScreen
import com.meokq.presentation.ui.store.StoreScreen

@Composable
fun MainNavHost(navController: NavHostController = rememberNavController()) {
    NavHost(navController = navController, startDestination = MeokQDestination.QUEST_ROUTE) {
        composable(MeokQDestination.QUEST_ROUTE) {
            QuestScreen(
                navController = navController
            )
        }
        composable(
            arguments = listOf(navArgument("id") { type = NavType.StringType }),
            route = MeokQDestination.STORE_ROUTE + "/{id}"
        ) { backStackEntry ->
            var id: String = backStackEntry.arguments?.getString("id") ?: "key"
            StoreScreen(
                onBackClick = {
                    navController.popBackStack()
                },
                id = id
            )
        }
        composable(MeokQDestination.COUPON_ROUTE) {
            CouponScreen()
        }
    }
}

//@Composable
//fun LoginNavHost(navController: NavHostController = rememberNavController()) {
//    NavHost(
//        navController = navController,
//        startDestination = MeokQDestination.LOGIN
//    ) {
//        composable(MeokQDestination.QUEST_ROUTE) {
//            MainNavHost(navController = navController)
//        }
//        composable(MeokQDestination.LOGIN) {
//            LoginScreen(
//                onNavigate={
//                    navController.navigate(MeokQDestination.QUEST_ROUTE)
//                }
//            )
//        }
//    }
//}