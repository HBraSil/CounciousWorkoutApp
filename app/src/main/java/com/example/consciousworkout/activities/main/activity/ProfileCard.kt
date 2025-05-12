package com.example.consciousworkout.activities.main.activity

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.consciousworkout.R
import com.example.consciousworkout.model.Gender
import com.example.consciousworkout.model.User
import com.example.consciousworkout.ui.theme.BackgroundMainScreenProfileCard
import com.example.consciousworkout.ui.theme.BackgroundPhotoProfileCard
import com.example.consciousworkout.ui.theme.RussoOne
import com.example.consciousworkout.ui.theme.ShapeTopTextMainScreen
import com.example.consciousworkout.ui.theme.TextColorProfileCard


@Composable
fun ProfileCard(user: User) {
    Card(
        onClick = {},
        modifier = Modifier
            .padding(top = 40.dp, start = 20.dp, end = 20.dp)
            .fillMaxWidth()
            .height(130.dp),
        shape = ShapeTopTextMainScreen.medium,
        colors = CardDefaults.cardColors(BackgroundMainScreenProfileCard),
        elevation = CardDefaults.cardElevation(5.dp)
    ) {
        Row {
            //Card image profile
            Card (
                modifier = Modifier
                    .padding(start = 20.dp, top = 20.dp)
                    .size(90.dp),
                shape = CircleShape,
                colors = CardDefaults.cardColors(BackgroundPhotoProfileCard),
            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center  // Aqui centraliza o conteúdo
                ){
                    Icon(
                        imageVector = Icons.Sharp.Person,
                        contentDescription = "Profile icon",
                        modifier = Modifier
                            .size(40.dp)
                    )
                }
            }


            // Gender icon
            Icon(
                painter = painterResource(
                    id = when (user.gender) {
                        Gender.MALE -> R.drawable.ic_male
                        Gender.FEMALE -> R.drawable.ic_female
                        null -> TODO()
                    }
                )
                ,
                contentDescription = "Gender Icon",
                tint = when (user.gender) {
                    Gender.MALE -> Color.Blue
                    Gender.FEMALE -> Color.Magenta
                    null -> TODO()
                },
                modifier = Modifier
                    .padding(top = 10.dp)
                    .size(24.dp)
            )


            // Column Person/Age
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(2f),
                verticalArrangement = Arrangement.SpaceAround,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Person",
                    fontWeight = Bold,
                    fontSize = 20.sp,
                    fontFamily = RussoOne,
                    color = TextColorProfileCard
                )
                Text(
                    text = "Age",
                    fontWeight = Bold,
                    fontSize = 12.sp,
                    fontFamily = RussoOne,
                    color = TextColorProfileCard
                )
            }
        }
    }
}
