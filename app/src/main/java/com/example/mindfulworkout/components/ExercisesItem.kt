package com.example.mindfulworkout.components

import android.util.Log
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.DarkGray
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight.Companion.W900
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mindfulworkout.ui.theme.CircleShape
import com.example.mindfulworkout.ui.theme.backgroundColorElementsCardExercisesDarker
import com.example.mindfulworkout.ui.theme.backgroundColorCardExercises


@Composable
fun ExerciseBox(
    onValueWeightChange: (String) -> Unit = {},
    onValueRepChange: (String) -> Unit = {},
    onValueSetChange: (String) -> Unit = {},
    onValueExerciseNameChange: (String) -> Unit = {},
    selectedButton: (Boolean) -> Unit = { false }
) {
    var weight by remember { mutableStateOf("") }
    var set by remember { mutableStateOf("") }
    var rep by remember { mutableStateOf("") }
    var exerciseName by remember { mutableStateOf("") }
    var checked by remember { mutableStateOf(false) }


    Card(
        modifier = Modifier.padding(4.dp),
        colors = CardDefaults.cardColors(backgroundColorCardExercises),
        /*elevation = CardDefaults.cardElevation(
            defaultElevation = .dp
        )*/
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            // LINHA DE CIMA
            Row(
                modifier = Modifier
                    .padding(5.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {

                Box(
                    modifier = Modifier
                        .padding(top = 8.dp)
                        .size(24.dp)
                        .border(2.dp, Black, shape = CircleShape)
                        .clickable {
                            checked = !checked
                            selectedButton(checked)
                        },
                    contentAlignment = Alignment.Center
                ) {
                    if (checked) {
                        Icon(
                            imageVector = Icons.Default.Done, // ou Icons.Default.Info
                            contentDescription = "Selecionado",
                            modifier = Modifier.size(16.dp),
                            tint = Black
                        )
                    }
                }

                TextField(
                    value = exerciseName,
                    onValueChange = {
                        exerciseName = it
                        onValueExerciseNameChange(exerciseName)
                    },
                    label = {
                        Text(
                            text = "Exercise name",
                            fontSize = 12.sp,
                            color = DarkGray,
                            fontWeight = W900
                        )
                    },
                    modifier = Modifier
                        .width(200.dp)
                        .padding(top = 8.dp)
                        .align(Alignment.CenterVertically),
                    textStyle = TextStyle(
                        fontSize = 14.sp,
                        color = Black,
                        fontWeight = W900
                    ),
                    singleLine = true,
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = backgroundColorElementsCardExercisesDarker,
                        unfocusedContainerColor = backgroundColorCardExercises
                    ),
                    maxLines = 1
                )

                OutlinedTextField(
                    value = weight,
                    onValueChange = {
                        onValueWeightChange(it)
                        weight = it
                    },
                    label = {
                        Text(
                            text = "Weight ",
                            fontSize = 14.sp,
                            color = Gray,
                            fontWeight = W900
                        )
                    },
                    //shape = RoundedCornerShape(12.dp),
                    modifier = Modifier
                        .width(110.dp)
                        .align(Alignment.CenterVertically),
                    colors = TextFieldDefaults.colors(
                        focusedIndicatorColor = Black,
                    ),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number
                    ),
                    maxLines = 1
                )
            }


            // LINHA DE BAIXO
            Row(
                modifier = Modifier
                    .padding(bottom = 5.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {

                RepAndSetItem("Reps") {
                    rep = it
                    onValueRepChange(rep)
                }
                RepAndSetItem("Sets") {
                    set = it
                    onValueSetChange(set)
                }

            }
        }
    }
}

@Preview
@Composable
fun ExerciseItemPreview() {
    ExerciseBox()
}