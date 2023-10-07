package com.meokq.presentation.ui.store

import CustomTypo
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.meokq.presentation.R
import com.meokq.presentation.model.QuestStatus
import com.meokq.presentation.theme.Gray300
import com.meokq.presentation.theme.White
import com.meokq.presentation.ui.global.TextBadge

@Preview
@Composable
fun MissionInfoPreview() {
    MissionInfo(
        status = QuestStatus.PUBLISHED,
        reward = "제목",
        missionDescription = "설명"
    )
}

@Composable
fun MissionInfo(
    status: QuestStatus,
    reward: String,
    missionDescription: String,
) {
    Row(
        modifier = Modifier
            .shadow(
                elevation = 20.dp,
                spotColor = Color(0x0D7D7D7D),
                ambientColor = Color(0x0D7D7D7D)
            )
            .fillMaxWidth()
            .background(color = White, shape = RoundedCornerShape(size = 12.dp))
            .clickable {
                //TODO add copy clipboar logic
            }
            .padding(horizontal = 16.dp, vertical = 17.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.Start
        ) {
            TextBadge(
                backgroundColor = status.backgroundColor,
                textColor = status.textColor,
                text = status.text
            )
            Text(
                text = reward, style = CustomTypo.headlineLarge
            )
            Text(
                text = missionDescription, style = CustomTypo.labelMedium.copy(
                    color = Gray300
                )
            )
        }
        Image(
            modifier = Modifier
                .width(15.dp),
            painter = painterResource(id = R.drawable.ic_alert),
            contentDescription = "copy button"
        )
    }
}