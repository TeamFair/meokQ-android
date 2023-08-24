package com.meokq.presentation.ui.signin

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import com.meokq.presentation.R
import com.meokq.presentation.getResourceId

@Composable
fun LoginButton(
    img:String
){
    var imgUrl = "ic_login_${img}_18"
    Row(
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Image(
            painter = painterResource(
                id = getResourceId(imgUrl, R.drawable::class.java),
            ),
           contentDescription = "login logo"
        )
        Text(
            text = "Login with ${img}",
        )
        Text(
            text = "",)
    }
}
