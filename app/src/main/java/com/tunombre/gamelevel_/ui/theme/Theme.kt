package com.tunombre.gamelevel_.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

/**
 * Paleta unificada estilo “mock morado” para claro y oscuro.
 * Si prefieres que oscuro sea negro/verde, podemos volver a separar los esquemas.
 */
private val AppDarkColors = darkColorScheme(
    primary      = ElectricBlue,  // botones/acciones principales
    secondary    = YellowAccent,  // acento (antes NeonGreen)
    background   = PurpleBg,      // fondo general
    surface      = PurpleCard,    // tarjetas/containers
    onPrimary    = OnDark,        // texto/ícono sobre primary
    onSecondary  = BgBlack,       // texto sobre amarillo (mejor contraste)
    onBackground = OnDark,        // texto principal
    onSurface    = OnDark         // texto sobre surface
)

private val AppLightColors = lightColorScheme(
    primary      = ElectricBlue,
    secondary    = YellowAccent,
    background   = PurpleBg,
    surface      = PurpleCard,
    onPrimary    = OnDark,
    onSecondary  = BgBlack,
    onBackground = OnDark,
    onSurface    = OnDark
)

@Composable
fun GameLevel_Theme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    // Si quieres que SIEMPRE sea el mock morado, usa AppLightColors.
    val colors = if (darkTheme) AppDarkColors else AppLightColors

    MaterialTheme(
        colorScheme = colors,
        typography  = Typography,
        content     = content
    )
}
