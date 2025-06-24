package com.example.mindfulworkout.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.text.font.FontWeight.Companion.W900
import androidx.compose.ui.unit.dp
import com.example.mindfulworkout.R
import com.example.mindfulworkout.ui.theme.BackgroundMainScreenGradient
import com.example.mindfulworkout.ui.theme.BackgroundTopBarElements
import com.example.mindfulworkout.ui.theme.backgroundNavigationDrawerSheet
import com.example.mindfulworkout.ui.theme.contentNavigationDrawerSheet
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BaseScaffold(
    onClickCardTitle: () -> Unit = {},
    onClickMenuItem: (Int) -> Unit = {},
    floatingActionButton: @Composable () -> Unit = {},
    actions: @Composable RowScope.() -> Unit = {},
    content: @Composable (PaddingValues) -> Unit = {}
) {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()


    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(
                modifier = Modifier.width(200.dp),
                drawerContainerColor = backgroundNavigationDrawerSheet,
                drawerContentColor = contentNavigationDrawerSheet
            ) {
                Text("Menu", modifier = Modifier.padding(16.dp))
                HorizontalDivider(thickness = 6.dp, color = Black)
                Text(
                    "Exercises List", modifier = Modifier
                        .padding(16.dp)
                        .clickable {
                            onClickMenuItem(R.string.list_exercises_screen)
                        }
                )
                HorizontalDivider(color = Black)
                Text(
                    "Profile", modifier = Modifier
                        .padding(16.dp)
                        .clickable {
                            onClickMenuItem(R.string.profile_screen)
                        }
                )
            }
        }
    ) {
        Scaffold(
            modifier = Modifier
                .background(BackgroundMainScreenGradient)
                .fillMaxSize(),
            containerColor = Color.Transparent,
            topBar = {
                TopAppBar(
                    navigationIcon = {
                        IconButton(
                            onClick = {
                                scope.launch {
                                    drawerState.open()
                                }
                            },
                            modifier = Modifier
                                .padding(start = 15.dp, top = 15.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Menu,
                                contentDescription = "Ícone de menu",
                                modifier = Modifier.size(35.dp)
                            )
                        }
                    },
                    title = {
                        Card(
                            onClick = {
                                onClickCardTitle()
                            },
                            modifier = Modifier
                                .padding(top = 15.dp)
                                .fillMaxWidth()
                                .wrapContentWidth(Alignment.CenterHorizontally)
                                .size(width = 200.dp, height = 45.dp),
                            colors = CardDefaults.cardColors(BackgroundTopBarElements),
                        ) {
                            Text(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .wrapContentSize(Alignment.Center),
                                text = "Mindful Workout",
                                color = Black,
                                fontWeight = W900
                            )
                        }
                    },
                    actions = actions,
                    colors = TopAppBarDefaults.topAppBarColors(
                        navigationIconContentColor = BackgroundTopBarElements,
                        titleContentColor = BackgroundTopBarElements,
                        actionIconContentColor = BackgroundTopBarElements,
                        containerColor = Color.Transparent // Garante que o gradiente do Modifier seja visível
                    )
                )
            },
            floatingActionButton = floatingActionButton,
            content = content
        )
    }
}