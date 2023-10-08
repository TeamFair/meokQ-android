package com.meokq.presentation.ui.quest

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.input.nestedscroll.nestedScrollModifierNode
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.meokq.presentation.R
import com.meokq.presentation.model.QuestUIModel
import com.meokq.presentation.theme.MeokQTheme
import com.meokq.presentation.ui.global.TextBadge
import com.meokq.presentation.ui.nav.MeokQDestination

@Composable
fun QuestScreen(
    questViewModel: QuestViewModel = viewModel(),
    navController: NavController = rememberNavController()
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(color = MeokQTheme.colorScheme.background)
    ) {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = MeokQTheme.colorScheme.primary,
                )
                .padding(vertical = 12.dp, horizontal = 30.dp)
        ) {
            val (title, arrow, setting) = createRefs()
            Text(
                modifier = Modifier
                    .clickable {
                        navController.navigate(MeokQDestination.DISTRICT_ROUTE)
                    }
                    .constrainAs(title) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)

                }, text = "서울 강남구", style = MeokQTheme.typography.Title02
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
                    .width(17.dp)
                    .height(17.dp)
                    .clickable {
                        navController.navigate(MeokQDestination.SETTING_ROUTE)
                    }
                    .constrainAs(setting) {
                        end.linkTo(parent.end)
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                    },
                painter = painterResource(id = R.drawable.ic_setting_unactive),
                contentDescription = null
            )
        }
        Spacer(modifier = Modifier.height(26.dp))
        LazyColumn(
            modifier = Modifier.padding(horizontal = 17.dp),
            verticalArrangement = Arrangement.spacedBy(26.dp)
        ) {
            items(questViewModel.tmpQuestList) { quest ->
                QuestCard(
                    uiModel = quest,
                    onNavigate = {id ->
                        navController.navigate("${MeokQDestination.STORE_ROUTE}/$id")
                    }
                )
            }
        }
    }

}

@Composable
fun QuestCard(
    modifier: Modifier = Modifier, uiModel: QuestUIModel,
    onNavigate: (String) -> Unit
) {
    Row(
        modifier = Modifier
            .shadow(
                elevation = 20.dp, spotColor = Color(0x0D7D7D7D), ambientColor = Color(0x0D7D7D7D)
            )
            .clickable {
                onNavigate(uiModel.marketId)
            }
            .fillMaxWidth()
            .background(
                color = Color.White, shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
            )
            .padding(16.dp),

        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        //image section
        AsyncImage(
            modifier = Modifier
                .width(76.dp)
                .height(76.dp)
                .border(
                    width = 0.8.dp,
                    color = Color(0xFFD4D4D4),
                    shape = RoundedCornerShape(size = 6.dp)
                ), model = uiModel.logoImage, contentDescription = null
        )
        Spacer(modifier = Modifier.width(14.dp))
        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Row {
                Text(
                    text = uiModel.name, style = MeokQTheme.typography.Heading01.copy(
                        lineHeight = 21.sp
                    )
                )
                Spacer(modifier = Modifier.width(8.dp))
                TextBadge(
                    backgroundColor = MeokQTheme.colorScheme.badgeYellow,
                    textColor = MeokQTheme.colorScheme.textYellow,
                    text = "퀘스트 ${uiModel.missionCount}개"
                )
            }

            StoreInfo(
                icon = R.drawable.ic_clock, text = uiModel.openingTime + "~" + uiModel.openingTime
            )
            StoreInfo(
                icon = R.drawable.ic_map, text = uiModel.address
            )

        }
        Image(
            modifier = Modifier.height(18.dp),
            painter = painterResource(id = R.drawable.ic_arrow_forward),
            contentDescription = null,
            colorFilter = ColorFilter.tint(color = MeokQTheme.colorScheme.gray200),
        )
    }
}

@Composable
fun StoreInfo(
    icon: Int, text: String
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier
                .width(10.dp)
                .height(10.dp),
            painter = painterResource(id = icon),
            contentDescription = "clock"
        )
        Spacer(modifier = Modifier.width(5.dp))
        Text(
            text = text,
            style = MeokQTheme.typography.Caption02.copy(color = MeokQTheme.colorScheme.gray400),
            overflow = TextOverflow.Ellipsis,
            maxLines = 2,
        )
    }
}