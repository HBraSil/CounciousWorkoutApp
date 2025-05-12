package com.example.consciousworkout.activities

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.consciousworkout.activities.main.activity.BodyImcCalc
import com.example.consciousworkout.activities.main.activity.ProfileCard
import com.example.consciousworkout.activities.main.activity.TopAppBarModified
import com.example.consciousworkout.model.Gender
import com.example.consciousworkout.model.User
import com.example.consciousworkout.ui.theme.BackgroundMainScreenGradient
import com.example.consciousworkout.ui.theme.ShapeTopTextMainScreen


@Composable
fun MainScreen(user: User) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundMainScreenGradient),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TopAppBarModified()
        ProfileCard(user)
        BodyImcCalc(user)
        BodyMainScreen()
    }
}


@Composable
fun BodyMainScreen() {

    Column {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {

            Card(
                modifier = Modifier
                    .padding(top = 20.dp, start = 20.dp)
                    .size(width = 180.dp, height = 45.dp),
                shape = ShapeTopTextMainScreen.small,
            ) {
                Text(
                    text = "Olá Brasil"

                )
            }
        }
    }
}


@Preview
@Composable
private fun MainScreenPreview() {
    MainScreen(User("John Doe", 25, 78.0, 1.79, Gender.MALE))
}

