package com.meokq.presentation.ui.quest

import CustomTypo
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.lifecycle.viewmodel.compose.viewModel
import com.meokq.presentation.R
import com.meokq.presentation.theme.MainBackground
import com.meokq.presentation.theme.MainPrimary
import com.meokq.presentation.theme.ShadowColor
import com.meokq.presentation.theme.White

@Composable
fun QuestScreen(questViewModel: QuestViewModel = viewModel()) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = MainBackground)
    ) {
        //TODO : AppHeader
        LazyColumn(
            modifier = Modifier.padding(horizontal = 17.dp),
            verticalArrangement = Arrangement.spacedBy(26.dp)
        ) {
            items(questViewModel.tmpQuestList) { it ->
                QuestCard()
            }
        }
    }

}

@Preview
@Composable
fun QuestCard(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .shadow(elevation = 10.dp, spotColor = ShadowColor, ambientColor = ShadowColor)
            .background(color = White, shape = RoundedCornerShape(size = 16.dp)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = White)
                .padding(horizontal = 23.dp, vertical = 25.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier
                    .width(74.dp)
                    .background(color = White, shape = RoundedCornerShape(size = 16.dp)),
                painter = painterResource(id = R.drawable.iv_logo_150),
                contentDescription = null
            )
            Spacer(modifier = Modifier.width(27.dp))
            Column {
                Text(
                    text = "커피크라운", style = CustomTypo.headlineLarge.copy(
                        fontWeight = FontWeight(700)
                    )
                )
                Text(text = "영업시간", style = CustomTypo.labelLarge)
                Text(text = "서울 강남구 테헤란로", style = CustomTypo.labelSmall)
            }
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = MainPrimary)
                .padding(vertical = 10.dp)
                .clickable { },
            contentAlignment = Alignment.Center
        ) {
            Text(text = "퀘스트 2개", style = CustomTypo.headlineLarge)
        }
    }
}