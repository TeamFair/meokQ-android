package com.meokq.presentation.ui.store

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun StoreScreen(
    onBackClick:()->Unit = {},
    id:String
){
    Text(id)
}