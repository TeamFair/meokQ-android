package com.meokq.presentation.ui.coupon

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
import com.meokq.presentation.theme.MeokQTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CouponScreen(couponViewModel: CouponViewModel = hiltViewModel()) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            modifier = Modifier.padding(vertical = 10.dp),
            text = "쿠폰", style = MeokQTheme.typography.Title02
        )
        var pagerState = rememberPagerState(pageCount = { 4 })
        val coroutineScope = rememberCoroutineScope()
        val titles = listOf(
            stringResource(R.string.coupon_tab_unuse),
            stringResource(R.string.coupon_tab_use)
        )
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
                                color = if (isSelected) MeokQTheme.colorScheme.textBlack else MeokQTheme.colorScheme.gray200

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
            if (couponViewModel.tmpCouponHistorys.isEmpty())
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
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
                //TODO: add coupon componet
            }

        }
    }

}