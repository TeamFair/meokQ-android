package com.meokq.presentation.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle

import androidx.compose.ui.graphics.Color

@Immutable
data class MeokQColorScheme(
    val primary: Color,
    val notificationYellow: Color,
    val tabYellow: Color,
    val badgeYellow: Color,
    val textYellow: Color,
    val background: Color,
    val kakaoLoginButton: Color,
    val textBlack: Color,
    val shadowColor: Color,
    val red: Color,
    val badgeRed: Color,
    val blue: Color,
    val badgeBlue: Color,
    val green: Color,
    val badgeGreen: Color,
    val gray100: Color,
    val gray200: Color,
    val gray300: Color,
    val gray400: Color,
) {
}

@Immutable
data class MeokQTypography(
    val Title01: TextStyle,
    val Title02: TextStyle,
    val Heading01: TextStyle,
    val Heading02: TextStyle,
    val Heading03: TextStyle,
    val Subtitle01: TextStyle,
    val Subtitle02: TextStyle,
    val Caption01: TextStyle,
    val Caption02: TextStyle,
    val Body: TextStyle,
    val Button: TextStyle,
    val TabBold: TextStyle,
    val TabRegular: TextStyle,
    val Badge01: TextStyle,
    val Badge02: TextStyle
)

val LocalMeokQColorScheme = staticCompositionLocalOf {
    MeokQColorScheme(
        primary = Color.Unspecified,
        notificationYellow = Color.Unspecified,
        tabYellow = Color.Unspecified,
        badgeYellow = Color.Unspecified,
        textYellow = Color.Unspecified,
        background = Color.Unspecified,
        kakaoLoginButton = Color.Unspecified,
        textBlack = Color.Unspecified,
        shadowColor = Color.Unspecified,
        red = Color.Unspecified,
        badgeRed = Color.Unspecified,
        blue = Color.Unspecified,
        badgeBlue = Color.Unspecified,
        green = Color.Unspecified,
        badgeGreen = Color.Unspecified,
        gray100 = Color.Unspecified,
        gray200 = Color.Unspecified,
        gray300 = Color.Unspecified,
        gray400 = Color.Unspecified,
    )
}

val LocalMeokQTypography = staticCompositionLocalOf {
    MeokQTypography(
        Title01 = TextStyle.Default,
        Title02 = TextStyle.Default,
        Heading01 = TextStyle.Default,
        Heading02 = TextStyle.Default,
        Heading03 = TextStyle.Default,
        Subtitle01 = TextStyle.Default,
        Subtitle02 = TextStyle.Default,
        Caption01 = TextStyle.Default,
        Caption02 = TextStyle.Default,
        Body = TextStyle.Default,
        Button = TextStyle.Default,
        TabBold = TextStyle.Default,
        TabRegular = TextStyle.Default,
        Badge01 = TextStyle.Default,
        Badge02 = TextStyle.Default
    )
}