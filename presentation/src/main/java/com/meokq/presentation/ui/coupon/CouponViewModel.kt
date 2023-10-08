package com.meokq.presentation.ui.coupon

import androidx.compose.runtime.mutableStateListOf
import com.meokq.presentation.base.BaseViewModel
import com.meokq.presentation.model.CouponHistory
import com.meokq.presentation.model.QuestUIModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CouponViewModel @Inject constructor() : BaseViewModel() {
    val tmpCouponHistorys = mutableStateListOf<CouponHistory>()
}