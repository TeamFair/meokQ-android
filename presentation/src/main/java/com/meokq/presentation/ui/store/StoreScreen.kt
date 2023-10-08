package com.meokq.presentation.ui.store

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.meokq.presentation.ui.global.TextBadge
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import coil.compose.AsyncImage
import com.meokq.presentation.R
import com.meokq.presentation.model.QuestStatus
import com.meokq.presentation.model.questStatusMap
import com.meokq.presentation.theme.MeokQTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun StoreScreen(
    onBackClick: () -> Unit = {},
    id: String,
    storeViewModel: StoreViewModel = viewModel(),
) {
    val uiModel = storeViewModel.tmpStoreList[0]


    Column(
        horizontalAlignment = Alignment.Start
    ) {
        Image(
            modifier = Modifier
                .clickable {
                    onBackClick()
                }
                .padding(horizontal = 15.dp, vertical = 12.dp),
            painter = painterResource(id = R.drawable.ic_arrow_back),
            colorFilter = ColorFilter.tint(color = Black),
            contentDescription = null
        )

        //1. store Info
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 13.dp)
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
            Spacer(modifier = Modifier.width(17.dp))
            Column {
                Text(
                    text = uiModel.name, style = MeokQTheme.typography.Heading01.copy(
                        lineHeight = 21.sp
                    )
                )
                Spacer(modifier = Modifier.height(3.dp))

                Row {
                    Text(
                        text = uiModel.address, style = MeokQTheme.typography.Caption01.copy(
                            color = MeokQTheme.colorScheme.gray200
                        )
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Image(
                        modifier = Modifier.clickable {
                            //TODO add copy clipboar logic
                        },
                        painter = painterResource(id = R.drawable.ic_copy_background),
                        contentDescription = "copy button"
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    val storeInfo: List<String> = listOf(
                        "퀘스트 ${uiModel.missionCount}개",
                        "${uiModel.openingTime} ~ ${uiModel.closingTime}",
                        uiModel.phoneNumber
                    )
                    storeInfo.forEach { info ->
                        TextBadge(
                            backgroundColor = MeokQTheme.colorScheme.badgeYellow, textColor = MeokQTheme.colorScheme.textYellow, text = info
                        )
                    }
                }
            }
        }
        var pagerState = rememberPagerState(pageCount = { 4 })
        val coroutineScope = rememberCoroutineScope()
        val titles = listOf("퀘스트", "진행중", "재도전", "완료")
        //2. Tab
        TabRow(
            selectedTabIndex = pagerState.currentPage,
            containerColor = Color.White,
            contentColor = Color.White,
            indicator = { tabPositions ->
                TabRowDefaults.Indicator(
                    modifier = Modifier
                        .tabIndicatorOffset(tabPositions[pagerState.currentPage])
                        .width(59.dp),
                    color = MeokQTheme.colorScheme.notificationYellow,
                )
            },
        ) {
            titles.forEachIndexed { index, title ->
                val isSelected = if (pagerState.currentPage == index) true else false
                Tab(selected = isSelected, onClick = {
                    coroutineScope.launch {
                        pagerState.animateScrollToPage(index)
//                         questStatusMap[titles[pagerState.currentPage]]
                    }
                }, text = {
                    Row {
                        Text(
                            text = title,
                            style = MeokQTheme.typography.TabBold.copy(
                                color = if (isSelected) Black else MeokQTheme.colorScheme.gray200

                            ),
                            maxLines = 1,
                        )
                        //TODO 숫자 data 추가
                        Text(
                            text = " 1",
                            style = MeokQTheme.typography.TabBold.copy(
                                color = if (isSelected) MeokQTheme.colorScheme.notificationYellow else MeokQTheme.colorScheme.gray200
                            ),
                            maxLines = 1,
                        )
                    }

                })
            }
        }
        HorizontalPager(state = pagerState) {
            if (storeViewModel.tmpMissionList.isEmpty())
                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .background(color = MeokQTheme.colorScheme.background),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = stringResource(R.string.store_mission_empty),
                        style = MeokQTheme.typography.Subtitle02.copy(
                            color = Color(0xFFA4A4A4)
                        )
                    )
                }
            LazyColumn(
                modifier = Modifier
                    .fillMaxHeight()
                    .background(color = MeokQTheme.colorScheme.background)
                    .padding(horizontal = 20.dp, vertical = 15.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp),
            ) {
                items(storeViewModel.tmpMissionList) { mission ->
                    questStatusMap[titles[pagerState.currentPage]]?.let { it1 ->
                        MissionInfo(
                            status = it1,
                            reward = mission.reward,
                            missionDescription = mission.missionDescription
                        )
                    } ?: run {
                        MissionInfo(
                            status = QuestStatus.PUBLISHED,
                            reward = mission.reward,
                            missionDescription = mission.missionDescription
                        )
                    }
                }
            }
        }
    }
}