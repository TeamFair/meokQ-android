package com.meokq.presentation.ui.setting

import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.meokq.presentation.R
import com.meokq.presentation.theme.MeokQTheme
import com.meokq.presentation.theme.MeokQTypography
import com.meokq.presentation.ui.nav.MeokQDestination
import com.meokq.presentation.ui.quest.QuestCard

@Composable
fun SettingScreen(
    onBackClick: () -> Unit = {}
) {
    val menuList = listOf(
        R.string.setting_menu_notice,
        R.string.setting_menu_customer,
        R.string.setting_menu_policy,
        R.string.setting_menu_version,
        R.string.setting_menu_logout,
        R.string.setting_menu_signout
    )
    Column {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = White,
                )
                .padding(vertical = 12.dp, horizontal = 30.dp)
        ) {
            val (arrow, title) = createRefs()
            Image(
                modifier = Modifier
                    .width(25.dp)
                    .clickable {
                        onBackClick()
                    }
                    .padding(start = 5.dp)
                    .constrainAs(arrow) {
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start)
                    },
                painter = painterResource(id = R.drawable.ic_arrow_back),
                contentDescription = null
            )
            Text(
                modifier = Modifier
                    .constrainAs(title) {
                        top.linkTo(parent.top)
                        end.linkTo(parent.end)
                        start.linkTo(parent.start)
                    }, text = "설정", style = MeokQTheme.typography.Title02
            )
        }

            Divider(modifier = Modifier.padding(bottom = 15.dp),color = Color(0xFFDDDDDD))
            menuWithText(menu = menuList[0])
            menuWithText(menu = menuList[1])
            menuWithText(menu = menuList[2])
            menuWithText(menu = menuList[3])
            menuWithText(menu = menuList[4], color = MeokQTheme.colorScheme.red)
            menuWithText(menu = menuList[5], color = MeokQTheme.colorScheme.red)
    }



}

@Composable
fun menuWithText(
    @StringRes menu: Int,
    onClick: () -> Unit = {},
    modifier: Modifier = Modifier,
    color: Color = MeokQTheme.colorScheme.textBlack
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(color = White)
            .clickable(onClick = onClick),
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            modifier = Modifier.padding(start= 23.dp),
            text = stringResource(id = menu),
            style = MeokQTheme.typography.Subtitle02.copy(
                color = color
            )
        )
        Divider(modifier = Modifier.padding(vertical = 15.dp),color = Color(0xFFDDDDDD))
    }
}