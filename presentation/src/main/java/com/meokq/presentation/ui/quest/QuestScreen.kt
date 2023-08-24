package com.meokq.presentation.ui.quest

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun QuestScreen(questViewModel: QuestViewModel = viewModel()) {
    Text(text = "QuestViewModel")
}