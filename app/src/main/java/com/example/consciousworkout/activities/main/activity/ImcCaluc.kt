package com.example.consciousworkout.activities.main.activity

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.DarkGray
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.Magenta
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.consciousworkout.R
import com.example.consciousworkout.components.BoxTextBMI
import com.example.consciousworkout.model.User
import com.example.consciousworkout.ui.theme.AntonSc
import com.example.consciousworkout.ui.theme.CircleShape
import com.example.consciousworkout.ui.theme.IconTint


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BodyImcCalc(user: User) {

    val result = 0
    var colorToIMC: Color


    var isClicked by remember { mutableStateOf(false) }
    var weight by remember { mutableStateOf("") }
    var height by remember { mutableStateOf("") }

    /*if (result > 30) {
        colorToIMC = Red
    } else if (result < 18,5) {
        colorToIMC = Yellow
    } else*/


    Row {
        Text(
            modifier = Modifier.padding(top = 35.dp, start = 20.dp),
            text = "cálculo de IMC:",
            fontFamily = AntonSc,
            fontSize = 30.sp,
            color = Black,
            fontWeight = Bold
        )
        Card(
            onClick = {},
            shape = CircleShape,
            elevation = CardDefaults.cardElevation(60.dp),
            modifier = Modifier
                .padding(top = 20.dp)
                .size(15.dp)
                .clickable { isClicked = true }
        ) {
            Icon(
                imageVector = Icons.Default.Info,
                contentDescription = "Informação sobre IMC",
                tint = IconTint
            )
        }
    }


    Row(
        modifier = Modifier
            .padding(start = 20.dp, end = 20.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        BoxTextBMI(
            label = "Kg",
            value = weight,
            onValueChange = { weight = it },
            modifier = Modifier.width(150.dp),
        )

        Text(
            text = "+",
            fontFamily = AntonSc,
            fontSize = 40.sp
        )

        BoxTextBMI(
            label = "Height",
            value = weight,
            onValueChange = { weight = it },
            modifier = Modifier.width(150.dp),
        )
    }

    Button(
        onClick = {

        },
        modifier = Modifier.padding(top = 15.dp),
    ) {
        Text(text = "Calcular")
    }

    BoxTextBMI(
        label = "Result",
        value = weight,
        onValueChange = { weight = it },
        modifier = Modifier
            .width(150.dp)
            .padding(top = 10.dp)
    )
}



@Preview
@Composable
private fun Test() {
    BodyImcCalc(User("John Doe", 25, 78.0, 1.79, null))
}