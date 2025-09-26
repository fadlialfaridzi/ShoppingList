package com.example.shoppinglist.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = PurpleDark,
    onPrimary = PurpleOn,
    primaryContainer = PurpleDarkPrimaryContainer,
    onPrimaryContainer = PurpleDarkOnPrimaryContainer,
    secondary = PurpleSecondary,
    secondaryContainer = PurpleDarkSecondaryContainer,
    onSecondaryContainer = PurpleDarkOnSecondaryContainer,
    background = PurpleDarkBackground,
    onBackground = PurpleDarkOnBackground,
    surface = PurpleSurfaceDark,
    onSurface = PurpleOnSurfaceDark
)

private val LightColorScheme = lightColorScheme(
    primary = PurpleLight,
    onPrimary = PurpleOn,
    primaryContainer = PurplePrimaryContainer,
    onPrimaryContainer = PurpleOnPrimaryContainer,
    secondary = PurpleSecondary,
    secondaryContainer = PurpleSecondaryContainer,
    onSecondaryContainer = PurpleOnSecondaryContainer,
    background = PurpleBackground,
    onBackground = PurpleOnBackground,
    surface = PurpleSurface,
    onSurface = PurpleOnSurface
)

@Composable
fun ShoppingListTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false,
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
    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}