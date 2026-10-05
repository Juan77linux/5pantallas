package com.example.myapplication.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

/**
 * Esquema de colores de marca para el tema claro.
 *
 * Los composables deben leer los colores desde [MaterialTheme.colorScheme]
 * en lugar de usar valores fijos, para que el tema oscuro funcione
 * automáticamente.
 */
private val EsquemaClaro = lightColorScheme(
    primary = AzulOrderBot,
    onPrimary = Color.White,
    primaryContainer = AzulClaroOrderBot,
    onPrimaryContainer = TextoPrincipal,
    secondary = TextoSecundario,
    onSecondary = Color.White,
    tertiary = VerdeOrderBot,
    tertiaryContainer = VerdeClaroOrderBot,
    background = FondoOrderBot,
    onBackground = TextoPrincipal,
    surface = Color.White,
    onSurface = TextoPrincipal,
    onSurfaceVariant = TextoSecundario
)

private val EsquemaOscuro = darkColorScheme(
    primary = AzulOrderBotOscuro,
    onPrimary = TextoPrincipal,
    primaryContainer = AzulContenedorOscuro,
    onPrimaryContainer = TextoPrincipalOscuro,
    secondary = TextoSecundarioOscuro,
    onSecondary = TextoPrincipal,
    tertiary = VerdeOrderBotOscuro,
    tertiaryContainer = VerdeContenedorOscuro,
    background = FondoOscuro,
    onBackground = TextoPrincipalOscuro,
    surface = SuperficieOscura,
    onSurface = TextoPrincipalOscuro,
    onSurfaceVariant = TextoSecundarioOscuro
)

@Composable
fun OrderBotTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = if (darkTheme) EsquemaOscuro else EsquemaClaro,
        typography = Typography,
        content = content
    )
}
