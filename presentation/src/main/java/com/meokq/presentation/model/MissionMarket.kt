package com.meokq.presentation.model

data class MissionMarket(
    val missionId : String,
    val missionDescription: String,
    val status : QuestStatus,
    val reward : String,
    val paidStatus : Boolean,
)
