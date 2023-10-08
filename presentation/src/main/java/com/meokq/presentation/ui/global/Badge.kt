package com.meokq.presentation.ui.global

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.meokq.presentation.theme.MeokQTheme

@Composable
fun TextBadge(
    backgroundColor: Color,
    textColor: Color,
    text: String
) {

    Text(
        modifier = Modifier
            .background(
                color = backgroundColor,
                shape = RoundedCornerShape(6.dp)
            )
            .padding(
                horizontal = 8.dp,
                vertical = 3.dp
            ),
        text = text, style = MeokQTheme.typography.Badge01.copy(
            color = textColor
        )
    )
}