package com.example.museoegipto.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

// Colores inspirados en el antiguo Egipto
val Gold = Color(0xFFFFD700)
val SandLight = Color(0xFFF4D03F)
val SandDark = Color(0xFFCDAD7F)
val Papyrus = Color(0xFFF5E6CA)
val NileBlue = Color(0xFF3498DB)
val RoyalPurple = Color(0xFF8E44AD)
val DesertBrown = Color(0xFFCD853F)
val HieroglyphBlack = Color(0xFF2C3E50)

private val DarkColorScheme = darkColorScheme(
    primary = Gold,
    secondary = SandDark,
    tertiary = NileBlue,
    background = HieroglyphBlack,
    surface = HieroglyphBlack.copy(alpha = 0.9f),
    onPrimary = HieroglyphBlack,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Papyrus,
    onSurface = Papyrus
)

private val LightColorScheme = lightColorScheme(
    primary = DesertBrown,
    secondary = SandLight,
    tertiary = NileBlue,
    background = Papyrus,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = HieroglyphBlack,
    onTertiary = Color.White,
    onBackground = HieroglyphBlack,
    onSurface = HieroglyphBlack
)

@Composable
fun MuseoEgiptoThemeOld(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false, // Desactivamos colores dinámicos para mantener el tema egipcio
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = AppTypography,
        content = content
    )
}