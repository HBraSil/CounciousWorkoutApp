package com.example.consciousworkout.activities.main.activity

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.consciousworkout.ui.theme.BackgroundMainScreenTopBar
import com.example.consciousworkout.ui.theme.ShapeTopTextMainScreen


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
                fontWeight = Bold,
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

