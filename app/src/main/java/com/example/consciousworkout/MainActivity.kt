package com.example.consciousworkout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.consciousworkout.activities.MainScreen
import com.example.consciousworkout.model.Gender
import com.example.consciousworkout.model.User
import com.example.consciousworkout.ui.theme.ConsciousWorkoutTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ConsciousWorkoutTheme {
                MainScreen(User("John Doe", 25, 78.0, 1.79, Gender.MALE))
            }
        }
    }
}
