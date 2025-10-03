package com.tunombre.gamelevel_.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val DarkColors = darkColorScheme(
    primary = ElectricBlue,
    secondary = NeonGreen,
    background = BgBlack,
    surface = SurfaceDark,
    onPrimary = OnDark,
    onSecondary = OnDark,
    onBackground = OnDark,
    onSurface = OnDark
)

private val LightColors = lightColorScheme(
    primary = ElectricBlue,
    secondary = NeonGreen,
    background = OnDarkMuted,
    surface = OnDarkMuted,
    onPrimary = BgBlack,
    onSecondary = BgBlack,
    onBackground = BgBlack,
    onSurface = BgBlack
)


@Composable
fun GameLevel_Theme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) DarkColors else LightColors


    MaterialTheme(
        colorScheme = colors,
         typography = Typography,
        // shapes = Shapes,
        content = content
    )
}
