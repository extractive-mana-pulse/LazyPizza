package com.seno.core.presentation.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

val textPrimary = Color(0xFF03131F)
val textSecondary = Color(0xFF627686)
val textSecondary8 = Color(0x14627686)
val textOnPrimary = Color(0xFFFFFFFF)
val background = Color(0xFFFAFBFC)
val surfaceHigher = Color(0xFFFFFFFF)
val surfaceHighest = Color(0xFFF0F3F6)
val outline = Color(0xFFE6E7ED)
val outline50 = Color(0x80E6E7ED)
val primary = Color(0xFFF36B50)
val primary8 = Color(0x14F36B50)
val primaryGradient = Brush.linearGradient(
    listOf(
        Color(0xFFF36B50),
        Color(0xFFF9966F),
    ),
)
val ColorScheme.success: Color
    get() = Color(0xFF2F9E5A)

val textPrimaryDark = Color(0xFFE8F1F8)
val textSecondaryDark = Color(0xFF8DA5B4)
val textSecondary8Dark = Color(0x148DA5B4)
val textOnPrimaryDark = Color(0xFFFFFFFF)
val backgroundDark = Color(0xFF0D1B24)
val surfaceHigherDark = Color(0xFF152130)
val surfaceHighestDark = Color(0xFF1C2D3A)
val outlineDark = Color(0xFF253545)
val outline50Dark = Color(0x80253545)
val primaryDark = Color(0xFFF36B50)
val primary8Dark = Color(0x1FF36B50)
val primaryGradientDark = Brush.linearGradient(
    listOf(
        Color(0xFFF36B50),
        Color(0xFFF9966F),
    ),
)
val ColorScheme.successDark: Color
    get() = Color(0xFF3DB870)