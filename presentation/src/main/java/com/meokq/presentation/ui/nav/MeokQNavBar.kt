package com.meokq.presentation.ui.nav

import Badge01
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.meokq.presentation.theme.Gray200
import com.meokq.presentation.theme.Gray400

data class BottomNavigationItem(
    val text: String,
    val selectIcon: Int,
    val unSelectIcon: Int
)

@Composable
fun BottomNavigationBar(
    selectedItemPosition: Int = 0,
    onItemSelected: (Int) -> Unit = {},
    modifier: Modifier = Modifier,
    items: List<BottomNavigationItem> = listOf(),
) {
    Row(modifier = modifier) {
        items.forEachIndexed { index, bottomNavigationItem ->
            BottomNavigationItem(
                Modifier.weight(1f),
                index == selectedItemPosition,
                bottomNavigationItem
            ) {
                onItemSelected.invoke(index)
            }
        }
    }
}

@Composable
fun BottomNavigationItem(
    modifier: Modifier = Modifier,
    isSelected: Boolean,
    item: BottomNavigationItem,
    onClick: () -> Unit,
) {

    Column(
        modifier
            .clickable(onClick = onClick)
            .padding(top = 19.dp, bottom = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier.width(24.dp),
            painter = painterResource(id = if (isSelected) item.selectIcon else item.unSelectIcon),
            contentDescription = item.text,
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = item.text,
            style = Badge01.copy(color = if (isSelected) Gray400 else Gray200)
        )
    }
}