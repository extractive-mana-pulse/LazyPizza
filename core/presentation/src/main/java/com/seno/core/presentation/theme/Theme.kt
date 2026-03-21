package com.seno.core.presentation.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

data class CustomColors(
    val textPrimary: Color,
    val textSecondary: Color,
    val textSecondary8: Color,
    val textOnPrimary: Color,
    val background: Color,
    val surfaceHigher: Color,
    val surfaceHighest: Color,
    val outline: Color,
    val outline50: Color,
    val primary: Color,
    val primary8: Color,
    val primaryGradient: Brush,
    val success: Color,
)

val LocalCustomColors = staticCompositionLocalOf {
    CustomColors(
        textPrimary = Color.Unspecified,
        textSecondary = Color.Unspecified,
        textSecondary8 = Color.Unspecified,
        textOnPrimary = Color.Unspecified,
        background = Color.Unspecified,
        surfaceHigher = Color.Unspecified,
        surfaceHighest = Color.Unspecified,
        outline = Color.Unspecified,
        outline50 = Color.Unspecified,
        primary = Color.Unspecified,
        primary8 = Color.Unspecified,
        primaryGradient = Brush.linearGradient(listOf(Color.Unspecified, Color.Unspecified)),
        success = Color.Unspecified,
    )
}

private val LightColorScheme =
    lightColorScheme(
        primary = primary,
        secondary = PurpleGrey40,
        tertiary = Pink40,
        background = background,
        surfaceContainerHigh = surfaceHigher,
        surfaceContainerHighest = surfaceHighest,
        outline = outline,
    )

private val DarkColorScheme = darkColorScheme(
    primary = primaryDark,
    background = backgroundDark,
    surface = surfaceHigherDark,
    outline = outlineDark,
    onPrimary = textOnPrimaryDark,
    onBackground = textPrimaryDark,
    onSurface = textPrimaryDark,
)

private val LightCustomColors = CustomColors(
    textPrimary = textPrimary,
    textSecondary = textSecondary,
    textSecondary8 = textSecondary8,
    textOnPrimary = textOnPrimary,
    background = background,
    surfaceHigher = surfaceHigher,
    surfaceHighest = surfaceHighest,
    outline = outline,
    outline50 = outline50,
    primary8 = primary8,
    primary = primary,
    primaryGradient = primaryGradient,
    success = Color(0xFF2F9E5A),
)

private val DarkCustomColors = CustomColors(
    textPrimary = textPrimaryDark,
    textSecondary = textSecondaryDark,
    textSecondary8 = textSecondary8Dark,
    textOnPrimary = textOnPrimaryDark,
    background = backgroundDark,
    surfaceHigher = surfaceHigherDark,
    surfaceHighest = surfaceHighestDark,
    outline = outlineDark,
    outline50 = outline50Dark,
    primary = primaryDark,
    primary8 = primary8Dark,
    primaryGradient = primaryGradientDark,
    success = Color(0xFF3DB870),
)

@Composable
fun LazyPizzaTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme
    val customColors = if (darkTheme) DarkCustomColors else LightCustomColors

    CompositionLocalProvider(LocalCustomColors provides customColors) {
        MaterialTheme(
            colorScheme = colorScheme,
            content = content,
        )
    }
}

val MaterialTheme.customColors: CustomColors
    @Composable
    get() = LocalCustomColors.current