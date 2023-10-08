package com.meokq.presentation.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import defaultMeokQTypography

@Composable
fun MeokQTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val view = LocalView.current
    if (!view.isInEditMode) {
        CompositionLocalProvider(
            LocalMeokQColorScheme provides defaultColors,
        ) {
            val statusBarColor = LocalMeokQColorScheme.current.primary.toArgb()
            SideEffect {
                val window = (view.context as Activity).window
                window.statusBarColor = statusBarColor
                WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars =
                    darkTheme
            }
        }
    }

    CompositionLocalProvider(
        LocalMeokQColorScheme provides defaultColors,
        LocalMeokQTypography provides defaultMeokQTypography
    ) {
        MaterialTheme(
            content = content
        )
    }
}

object MeokQTheme {
    val colorScheme: MeokQColorScheme
        @Composable
        get() = LocalMeokQColorScheme.current
    val typography: MeokQTypography
        @Composable
        get() = LocalMeokQTypography.current
}