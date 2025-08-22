package com.example.mindfulworkout.components

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
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight.Companion.W300
import androidx.compose.ui.text.font.FontWeight.Companion.W900
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mindfulworkout.ui.theme.CircleShape
import com.example.mindfulworkout.ui.theme.BackgroundColorElementsCardExercisesDarker
import com.example.mindfulworkout.ui.theme.BackgroundColorCardExercises
import com.example.mindfulworkout.ui.theme.LightbackgroundColorCardExercises


@Composable
fun ExerciseBox(
    readOnly: Boolean = false,
    onValueWeightChange: (String) -> String? = {""},
    onValueRepChange: (String) -> String? = {""},
    onValueSetChange: (String) -> String? = {""},
    onValueExerciseNameChange: (String) -> String? = {""},
    selectedButton: (Boolean) -> Unit = { false }
) {
    var weight by remember { mutableStateOf(onValueWeightChange("")!!) }
    var set by remember { mutableStateOf(onValueSetChange("")!!) }
    var rep by remember { mutableStateOf(onValueRepChange("")!!) }
    var exerciseName by remember { mutableStateOf(onValueExerciseNameChange("")!!) }
    var checked by remember { mutableStateOf(false) }
    var onlyForRead by remember { mutableStateOf(readOnly) }


    Card(
        modifier = Modifier.padding(4.dp),
        colors =
            if (readOnly)
                CardDefaults.cardColors(BackgroundColorCardExercises)
            else
                CardDefaults.cardColors(LightbackgroundColorCardExercises)
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
                        .clickable(enabled = !readOnly){
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
                        onValueExerciseNameChange(it)
                    },
                    label = {
                        Text(
                            text = "Exercise name",
                            fontSize = 12.sp,
                            color = White,
                            fontWeight = W300
                        )
                    },
                    modifier = Modifier
                        .width(200.dp)
                        .padding(top = 8.dp)
                        .align(Alignment.CenterVertically),
                    textStyle = TextStyle(
                        fontSize = 14.sp,
                        color = White,
                        fontWeight = W900
                    ),
                    singleLine = true,
                    colors =
                        if (onlyForRead) {
                            TextFieldDefaults.colors(
                                focusedContainerColor = BackgroundColorElementsCardExercisesDarker,
                                unfocusedContainerColor = Transparent,
                                focusedIndicatorColor = Black
                            )
                        } else {
                            TextFieldDefaults.colors(
                                focusedContainerColor = LightbackgroundColorCardExercises,
                                unfocusedContainerColor = Transparent,
                                focusedIndicatorColor = Black
                            )
                        },
                    maxLines = 1,
                    readOnly = readOnly
                )

                OutlinedTextField(
                    value = weight,
                    onValueChange = {
                        weight = it
                        onValueWeightChange(it)
                    },
                    label = {
                        Text(
                            text = "Weight ",
                            fontSize = 12.sp,
                            color = White,
                            fontWeight = W300
                        )
                    },
                    //shape = RoundedCornerShape(12.dp),
                    modifier = Modifier
                        .width(110.dp)
                        .align(Alignment.CenterVertically),
                    colors = TextFieldDefaults.colors(
                        focusedIndicatorColor = White,
                        focusedContainerColor = BackgroundColorElementsCardExercisesDarker,
                        unfocusedContainerColor = BackgroundColorElementsCardExercisesDarker,

                    ),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number
                    ),
                    maxLines = 1,
                    readOnly = readOnly
                )
            }


            // LINHA DE BAIXO
            Row(
                modifier = Modifier
                    .padding(bottom = 5.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                RepAndSetItem(rep, "Reps", readOnly) {
                    rep = it
                    onValueRepChange(rep)
                }
                RepAndSetItem(set,"Sets", readOnly) {
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
    //ExerciseBox()
}