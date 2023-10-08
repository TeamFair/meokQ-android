package com.meokq.presentation.model

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.meokq.presentation.theme.MeokQTheme

enum class QuestStatus(
    val status: String,
) {
    PUBLISHED("published"),
    PENDING("pending"),
    REJECTED("rejected"),
    APPROVED("approved")
}

val questStatusMap = mapOf(
    "퀘스트" to QuestStatus.PUBLISHED,
    "진행중" to QuestStatus.PENDING,
    "재도전" to QuestStatus.REJECTED,
    "완료" to QuestStatus.APPROVED,
)

data class QuestStatusUI(val text: String, val textColor: Color, val backgroundColor: Color)

@Composable
fun QuestStatus.ui(): QuestStatusUI {
    return when (this) {
        QuestStatus.PUBLISHED -> {
            QuestStatusUI(
                "수락전",
                MeokQTheme.colorScheme.gray300,
                MeokQTheme.colorScheme.background
            )
        }

        QuestStatus.PENDING -> {
            QuestStatusUI(
                "진행중",
                MeokQTheme.colorScheme.blue,
                MeokQTheme.colorScheme.badgeBlue
            )
        }

        QuestStatus.REJECTED -> {
            QuestStatusUI("재도전", MeokQTheme.colorScheme.red, MeokQTheme.colorScheme.badgeRed)
        }

        QuestStatus.APPROVED -> {
            QuestStatusUI(
                "완료",
                MeokQTheme.colorScheme.green,
                MeokQTheme.colorScheme.badgeGreen
            )
        }
    }
}