package com.meokq.presentation.model

import androidx.compose.ui.graphics.Color
import com.meokq.presentation.theme.BackGround
import com.meokq.presentation.theme.BadgeBlue
import com.meokq.presentation.theme.BadgeGreen
import com.meokq.presentation.theme.BadgeRed
import com.meokq.presentation.theme.Blue
import com.meokq.presentation.theme.Gray300
import com.meokq.presentation.theme.Green
import com.meokq.presentation.theme.Red
import com.meokq.presentation.theme.TextBlack

enum class QuestStatus(
    val status: String,
    val text: String,
    val textColor: Color,
    val backgroundColor: Color,
) {
    PUBLISHED("published", "수락전", Gray300, BackGround),
    PENDING("pending", "진행중", Blue, BadgeBlue),
    REJECTED("rejected", "재도전", Red, BadgeRed),
    APPROVED("approved", "완료", Green, BadgeGreen)
}
val questStatusMap = mapOf(
    "퀘스트" to QuestStatus.PUBLISHED,
    "진행중" to QuestStatus.PENDING,
    "재도전" to QuestStatus.REJECTED,
    "완료" to QuestStatus.APPROVED,
)