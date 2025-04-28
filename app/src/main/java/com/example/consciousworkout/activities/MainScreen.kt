package com.example.consciousworkout.activities

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Build
import androidx.compose.material.icons.outlined.Call
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.rounded.Build
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material.icons.sharp.Build
import androidx.compose.material.icons.sharp.Call
import androidx.compose.material.icons.sharp.Menu
import androidx.compose.material.icons.sharp.Person
import androidx.compose.material.icons.sharp.Search
import androidx.compose.material.icons.twotone.Build
import androidx.compose.material.icons.twotone.Call
import androidx.compose.material.icons.twotone.Menu
import androidx.compose.material.icons.twotone.Person
import androidx.compose.material.icons.twotone.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.consciousworkout.R
import com.example.consciousworkout.model.Gender
import com.example.consciousworkout.model.User
import com.example.consciousworkout.ui.theme.BackgroundMainScreenGradient
import com.example.consciousworkout.ui.theme.BackgroundMainScreenProfileCard
import com.example.consciousworkout.ui.theme.BackgroundMainScreenTopBar
import com.example.consciousworkout.ui.theme.RussoOne
import com.example.consciousworkout.ui.theme.ShapeTopTextMainScreen
import com.example.consciousworkout.ui.theme.TextColorProfileCard


@Composable
fun MainScreen(user: User) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundMainScreenGradient)
    ) {
        TopAppBarModified()
        ProfileCard(user)
    }
}



@Composable
fun TopAppBarModified() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 15.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        IconButton(
            onClick = {},
            modifier = Modifier.padding(start = 15.dp, top = 20.dp),
            content = {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = "Ícone de menu",
                    tint = White,
                    modifier = Modifier.size(35.dp)
                )
            },
        )


        Card(
            modifier = Modifier
                .padding(top = 20.dp)
                .size(width = 180.dp, height = 45.dp),
            shape = ShapeTopTextMainScreen.medium,
            colors = CardDefaults.cardColors(BackgroundMainScreenTopBar),
        ) {
            Text(
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(),
                text = "Conscious Workout",
                color = White,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
            )
        }

            Icon(
                imageVector = Icons.Rounded.Search,
                contentDescription = "Ir para perfil",
                tint = White,
                modifier = Modifier
                    .padding(end = 20.dp, top = 26.dp)
                    .size(35.dp)
            )
        }
}



@Composable
fun ProfileCard(user: User) {
    Card(
        modifier = Modifier
            .padding(top = 40.dp, start = 20.dp, end = 20.dp)
            .fillMaxWidth()
            .height(130.dp),
        shape = ShapeTopTextMainScreen.medium,
        colors = CardDefaults.cardColors(BackgroundMainScreenProfileCard)
    ) {
        Row {
            Column(
                modifier = Modifier.fillMaxHeight(),
                verticalArrangement = Arrangement.Center
            ) {
                Card(
                    onClick = {},
                    modifier = Modifier
                        .padding(start = 20.dp)
                        .size(100.dp)
                        .clip(CircleShape)
                        .background(Color.Gray),
                    content = {
                        Icon(
                            imageVector = Icons.Sharp.Person,
                            contentDescription = "Ícone de menu"
                        )
                    }
                )
            }


            // Ícone do gênero
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
                    .padding(top = 10.dp).size(24.dp)
            )


            Icon(Icons.Default.Person, contentDescription = "Localized description")
            Icon(Icons.Rounded.Person, contentDescription = "Localized description")
            Icon(Icons.Filled.Person, contentDescription = "Localized description")
            Icon(Icons.Outlined.Person, contentDescription = "Localized description")
            Icon(Icons.Sharp.Person, contentDescription = "Localized description")
            Icon(Icons.TwoTone.Person, contentDescription = "Localized description")


            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(2f),
                verticalArrangement = Arrangement.SpaceAround,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Person",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    fontFamily = RussoOne,
                    color = TextColorProfileCard
                )
                Text(
                    text = "Age",
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp,
                    fontFamily = RussoOne,
                    color = TextColorProfileCard
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

