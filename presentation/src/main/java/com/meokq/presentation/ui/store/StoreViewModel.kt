package com.meokq.presentation.ui.store

import androidx.compose.runtime.mutableStateListOf
import com.meokq.presentation.base.BaseViewModel
import com.meokq.presentation.model.QuestUIModel
import javax.inject.Inject

class StoreViewModel @Inject constructor() : BaseViewModel() {
    //레이아웃 작업을 위해 임시로 만들어둔 list
    val tmpStoreList = mutableStateListOf<QuestUIModel>()
    val tmpQuest = QuestUIModel(
        address = "서울특별시 강남구 대조동",
        businessOwnerId = "bigSample2",
        marketId = "marketIdSample1",
        district = "1168000000",
        logoImage = "https://firebasestorage.googleapis.com/v0/b/teamfair-7fb46.appspot.com/o/defaultImage%2FLogo.png?alt=media&token=3ff92859-7919-49e6-a4ca-173f1635df91",
        missionCount = 3,
        name = "테스트마켓",
        openingTime = "09:00",
        closingTime = "18:00",
        phoneNumber = "070-1111-2222"
    )

    init {
        tmpStoreList.add(tmpQuest)
    }
}