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
import androidx.compose.foundation.layout.fillMaxHeight
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
import com.meokq.presentation.theme.BackGround
import com.meokq.presentation.theme.Primary
import com.meokq.presentation.theme.ShadowColor
import com.meokq.presentation.theme.White

@Composable
fun QuestScreen(questViewModel: QuestViewModel = viewModel()) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(color = BackGround)
    ) {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = Primary,
                    shape = RoundedCornerShape(bottomStart = 20.dp, bottomEnd = 20.dp)
                )
                .padding(vertical = 36.dp, horizontal = 30.dp)
        ) {
            val (title, arrow, setting) = createRefs()
            Text(
                modifier = Modifier.constrainAs(title) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)

                }, text = "서울 강남구", style = CustomTypo.titleSmall.copy(
                    fontWeight = FontWeight(600)
                )
            )
            Image(
                modifier = Modifier
                    .padding(start = 5.dp)
                    .constrainAs(arrow) {
                        top.linkTo(title.top)
                        bottom.linkTo(title.bottom)
                        start.linkTo(title.end)
                    },
                painter = painterResource(id = R.drawable.ic_path_10),
                contentDescription = null
            )
            Image(
                modifier = Modifier
                    .width(24.dp)
                    .height(24.dp)
                    .constrainAs(setting) {
                        end.linkTo(parent.end)
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                    },
                painter = painterResource(id = R.drawable.ic_setting),
                contentDescription = null
            )
        }
        Spacer(modifier = Modifier.height(26.dp))
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
            .shadow(elevation = 10.dp, spotColor = ShadowColor, ambientColor = ShadowColor),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = White,
                    shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
                )
                .padding(horizontal = 23.dp, vertical = 25.dp),

            verticalAlignment = Alignment.CenterVertically
        ) {
            //image section
            Image(
                modifier = Modifier
                    .width(74.dp)
                    .background(color = White, shape = RoundedCornerShape(size = 16.dp)),
                painter = painterResource(id = R.drawable.iv_logo_150),
                contentDescription = null
            )
            Spacer(modifier = Modifier.width(27.dp))
            Column(
                verticalArrangement = Arrangement.spacedBy(7.dp)
            ) {
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
                .background(
                    color = Primary,
                    shape = RoundedCornerShape(bottomStart = 16.dp, bottomEnd = 16.dp)
                )
                .padding(vertical = 10.dp)
                .clickable { },
            contentAlignment = Alignment.Center
        ) {
            Text(text = "퀘스트 2개", style = CustomTypo.headlineLarge)
        }
    }
}