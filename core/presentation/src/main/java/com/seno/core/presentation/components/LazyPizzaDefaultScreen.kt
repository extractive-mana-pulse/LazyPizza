package com.seno.core.presentation.components

import android.app.Activity
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.luminance
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.seno.core.presentation.theme.customColors
import com.seno.core.presentation.utils.isScrollingUp

@Composable
fun LazyPizzaDefaultScreen(
    snackbarHostState: SnackbarHostState,
    modifier: Modifier = Modifier,
    containerColor: Color = MaterialTheme.customColors.background,
    listState: LazyListState,
    bottomBar: @Composable () -> Unit = {},
    content: @Composable () -> Unit = {},
) {

    val isScrollingUp by listState.isScrollingUp()
    Scaffold(
        bottomBar = {
            AnimatedVisibility(
                visible = isScrollingUp,
                enter = slideInVertically(initialOffsetY = { it }),
                exit = slideOutVertically(targetOffsetY = { it })
            ) {
                bottomBar()
            }
        },
        snackbarHost = {
            SnackbarHost(
                hostState = snackbarHostState,
                snackbar = {
                    Snackbar(
                        it,
                        containerColor = MaterialTheme.customColors.success,
                        contentColor = MaterialTheme.customColors.textPrimary,
                        actionContentColor = MaterialTheme.customColors.textPrimary,
                        dismissActionContentColor = MaterialTheme.customColors.textPrimary,
                        actionColor = MaterialTheme.customColors.textPrimary,
                        shape = RoundedCornerShape(8.dp),
                    )
                },
            )
        },
        modifier = modifier,
        containerColor = containerColor,
    ) { innerPadding ->
        val view = LocalView.current

        Box(
            modifier =
                Modifier
                    .padding(
                        top = innerPadding.calculateTopPadding(),
                        bottom = 0.dp
                    )
        ) {
            content()
        }

        if (!view.isInEditMode) {
            val darkIcons = colorScheme.background.luminance() > 0.5f

            SideEffect {
                val window = (view.context as Activity).window

                WindowCompat.setDecorFitsSystemWindows(window, false)

                WindowInsetsControllerCompat(window, view).apply {
                    isAppearanceLightStatusBars = darkIcons
                    isAppearanceLightNavigationBars = darkIcons
                }
            }
        }
    }
}