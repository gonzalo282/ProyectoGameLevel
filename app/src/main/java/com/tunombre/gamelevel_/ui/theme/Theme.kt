package com.tunombre.gamelevel_.ui.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

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

    // ===== CÓDIGO NUEVO AÑADIDO PARA LA BARRA DE ESTADO =====
    // SideEffect se usa para ejecutar código que afecta a elementos fuera de Compose (como la ventana de Android).
    val view = LocalView.current
    if (!view.isInEditMode) { // Nos aseguramos de que este código no se ejecute en la vista previa de Compose.
        SideEffect {
            // Obtenemos la ventana actual de la actividad.
            val window = (view.context as Activity).window
            // Establecemos el color de la barra de estado para que coincida con el fondo de nuestra app.
            window.statusBarColor = colors.background.toArgb()
            // Le decimos al sistema si los íconos de la barra de estado deben ser claros u oscuros.
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !darkTheme
        }
    }
    // ===== FIN DEL CÓDIGO AÑADIDO =====

    MaterialTheme(
        colorScheme = colors,
        typography  = Typography,
        content     = content
    )
}