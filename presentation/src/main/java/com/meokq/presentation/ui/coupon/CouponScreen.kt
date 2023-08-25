package com.meokq.presentation.ui.coupon

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun CouponScreen(couponViewModel: CouponViewModel = hiltViewModel()) {
    Text(text = "CouponScreen")
}