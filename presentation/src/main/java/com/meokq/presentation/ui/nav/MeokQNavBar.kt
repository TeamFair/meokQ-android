package com.meokq.presentation.ui.nav

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

data class BottomNavigationItem(
    val text: String, val icon: ImageVector
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
    val selectedIconColor = animateColorAsState(
        targetValue = if (isSelected) Color.Black else Color.LightGray,
        animationSpec = tween(300, 0, LinearEasing), label = ""
    )

    val selectedIconScale by animateFloatAsState(
        if (isSelected) 1.1f else 1f, label = "", animationSpec = tween(100, 0, LinearEasing)
    )

    Column(modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        IconButton(modifier = Modifier.size(64.dp), onClick = onClick) {
            Icon(
                modifier = Modifier.scale(selectedIconScale),
                imageVector = item.icon,
                contentDescription = item.text,
                tint = selectedIconColor.value
            )
        }
    }
}