package com.example.mindfulworkout.compose

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mindfulworkout.R
import com.example.mindfulworkout.components.BaseScaffold

enum class AppRouter(val route: String) {
    EXERCISES_TRACK_LIST("ExercisesTrackList"),
    MAIN_SCREEN("MainScreen"),
}

@Composable
fun MindWorkoutNavHost() {
    val navController = rememberNavController()


    NavHost(startDestination = AppRouter.MAIN_SCREEN.route, navController = navController) {
        composable(route = AppRouter.MAIN_SCREEN.route) {
            MainScreen(
                onClickMenuItem = { id ->
                    when (id) {
                        R.string.list_exercises_screen -> navController.navigate(AppRouter.EXERCISES_TRACK_LIST.route)
                        R.string.profile_screen -> navController.navigate(AppRouter.EXERCISES_TRACK_LIST.route)
                    }
                }
            )
        }

        composable(route = AppRouter.EXERCISES_TRACK_LIST.route) {
            ExerciseTrackListScreen {
                navController.navigate(AppRouter.MAIN_SCREEN.route)
            }
        }
    }
}