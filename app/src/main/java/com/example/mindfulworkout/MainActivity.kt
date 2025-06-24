package com.example.mindfulworkout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.mindfulworkout.compose.MainScreen
import com.example.mindfulworkout.compose.MindWorkoutNavHost
import com.example.mindfulworkout.model.Gender
import com.example.mindfulworkout.model.User
import com.example.mindfulworkout.ui.theme.ConsciousWorkoutTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ConsciousWorkoutTheme {
               // MainScreen(User("John Doe", 25, Gender.MALE, ""))
                MindWorkoutNavHost()
            }
        }
    }
}
