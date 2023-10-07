package com.meokq.presentation.ui.quest

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.meokq.presentation.base.BaseViewModel
import com.meokq.presentation.model.QuestUIModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class QuestViewModel @Inject constructor() : BaseViewModel() {
    //레이아웃 작업을 위해 임시로 만들어둔 list
    val tmpQuestList = mutableStateListOf<QuestUIModel>()
val tmpQuest =  QuestUIModel(
    address = "서울특별시 강남구 대조동",
    businessOwnerId = "bigSample2",
    marketId = "marketIdSample1",
    district = "1168000000",
    logoImage = "https://firebasestorage.googleapis.com/v0/b/teamfair-7fb46.appspot.com/o/defaultImage%2FLogo.png?alt=media&token=3ff92859-7919-49e6-a4ca-173f1635df91",
    missionCount = 3,
    name = "테스트마켓",
    openingTime = "09:00",
    closingTime = "18:00"
)
    init {
        tmpQuestList.add(
            tmpQuest
        )
        tmpQuestList.add(
            QuestUIModel(
                address = "서울특별시 강남구 대조동 3-5 1,2층에 있는데 얼마나 주소가 길면 이쁘게 나올까요",
                businessOwnerId = "bigSample1",
                marketId = "marketIdSample2",
                district = "1168000000",
                logoImage = "https://firebasestorage.googleapis.com/v0/b/teamfair-7fb46.appspot.com/o/defaultImage%2FLogo.png?alt=media&token=3ff92859-7919-49e6-a4ca-173f1635df91",
                missionCount = 3,
                name = "테스트마켓",
                openingTime = "09:00",
                closingTime = "18:00"
            )
        )
    }

}