package com.meokq.presentation.ui.coupon

import CustomTypo
import Subtitle02
import TabBold
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.meokq.presentation.R
import com.meokq.presentation.theme.BackGround
import com.meokq.presentation.theme.Gray200
import com.meokq.presentation.theme.NotificationYellow
import com.meokq.presentation.theme.White
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CouponScreen(couponViewModel: CouponViewModel = hiltViewModel()) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            modifier = Modifier.padding(vertical = 10.dp),
            text = "쿠폰", style = CustomTypo.titleMedium
        )
        var pagerState = rememberPagerState(pageCount = { 4 })
        val coroutineScope = rememberCoroutineScope()
        val titles = listOf(
            stringResource(R.string.coupon_tab_unuse),
            stringResource(R.string.coupon_tab_use)
        )
        TabRow(
            selectedTabIndex = pagerState.currentPage,
            containerColor = White,
            contentColor = White,
            indicator = { tabPositions ->
                TabRowDefaults.Indicator(
                    modifier = Modifier
                        .tabIndicatorOffset(tabPositions[pagerState.currentPage])
                        .width(59.dp),
                    color = NotificationYellow,
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
                            style = TabBold.copy(
                                color = if (isSelected) Color.Black else Gray200

                            ),
                            maxLines = 1,
                        )
                        //TODO 숫자 data 추가
                        Text(
                            text = " 1",
                            style = TabBold.copy(
                                color = if (isSelected) NotificationYellow else Gray200
                            ),
                            maxLines = 1,
                        )
                    }

                })
            }
        }
        HorizontalPager(state = pagerState) {
            if (couponViewModel.tmpCouponHistorys.isEmpty())
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .background(color = BackGround),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = stringResource(R.string.store_mission_empty),
                        style = Subtitle02.copy(
                            color = Color(0xFFA4A4A4)
                        )
                    )
                }
            LazyColumn(
                modifier = Modifier
                    .fillMaxHeight()
                    .background(color = BackGround)
                    .padding(horizontal = 20.dp, vertical = 15.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp),
            ) {
                //TODO: add coupon componet
            }

        }
    }

}