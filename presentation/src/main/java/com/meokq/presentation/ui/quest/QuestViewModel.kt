package com.meokq.presentation.ui.quest

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.meokq.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class QuestViewModel @Inject constructor() : BaseViewModel() {
    //레이아웃 작업을 위해 임시로 만들어둔 list
    val tmpQuestList = mutableStateListOf<String>()
    init {
        tmpQuestList.add("커피크라운")
        tmpQuestList.add("롯데리아")
    }
}