package com.meokq.presentation.model

data class MissionMarketUIModel(
    val missionId: Int,
    val missionDescription: String,
    val status: String,
    val reward: String,
    val paidStatus: Boolean,
)
