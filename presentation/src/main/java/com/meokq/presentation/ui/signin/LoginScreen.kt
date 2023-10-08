package com.meokq.presentation.ui.signin

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.meokq.presentation.R
import com.meokq.presentation.theme.MeokQTheme

@Preview
@Composable
fun LoginScreen(
    onNavigate: () -> Unit = {},
) {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .background(color = Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {
        Image(
            modifier = Modifier
                .width(104.dp)
                .height(104.dp),
            painter = painterResource(
                R.drawable.iv_logo_104
            ),
            contentDescription = "login logo",
        )

        Spacer(modifier = Modifier.height(109.dp))
        LoginButton(
            text = stringResource(R.string.text_button_sign_in_kakao),
            painter = painterResource(id = R.drawable.ic_login_kakao_18),
            backgroundColor = MeokQTheme.colorScheme.kakaoLoginButton
        )
        Spacer(modifier = Modifier.height(27.dp))
        LoginButton(
            text = stringResource(R.string.text_button_sign_in_google),
            painter = painterResource(id = R.drawable.ic_login_google_18),
            backgroundColor = Color.White,
            isBorder = true
        )
        Spacer(modifier = Modifier.height(25.dp))
        Text(
            modifier = Modifier.clickable(
                //임시 navigate 연결
                onClick = onNavigate
            ),
            text = stringResource(R.string.login_skip),
            style = MeokQTheme.typography.Caption02.copy(color = MeokQTheme.colorScheme.gray300),
            textDecoration = TextDecoration.Underline
        )
    }
}

@Composable
fun LoginButton(
    text: String,
    painter: Painter,
    backgroundColor: Color,
    isBorder: Boolean = false
) {
    Row(
        modifier = Modifier
            .border(
                width = 1.dp,
                color = if (isBorder) Color(0xFFD1D1D1) else Color.Transparent,
                shape = RoundedCornerShape(size = 50.dp)
            )
            .width(269.dp)
            .height(50.dp)
            .background(color = backgroundColor, shape = RoundedCornerShape(size = 50.dp)),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painter,
            contentDescription = "login logo"
        )
        Text(
            text = text,
            style = MeokQTheme.typography.TabRegular
        )
        Text(
            text = "",
        )
    }
}