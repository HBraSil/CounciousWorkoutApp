package com.example.mindfulworkout.compose

import android.util.Log
import android.widget.Toast
import com.example.mindfulworkout.R
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import com.example.mindfulworkout.ui.theme.BackgroundMainScreenGradient
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.Info
import androidx.compose.material.icons.sharp.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.DarkGray
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mindfulworkout.components.BaseScaffold
import com.example.mindfulworkout.components.BoxTextBMI
import com.example.mindfulworkout.components.ExerciseBox
import com.example.mindfulworkout.funcionalities.MultiFloatingButton
import com.example.mindfulworkout.model.Gender
import com.example.mindfulworkout.model.User
import com.example.mindfulworkout.model.WorkoutInfo
import com.example.mindfulworkout.ui.theme.AntonSc
import com.example.mindfulworkout.ui.theme.BackgroundMainScreenProfileCard
import com.example.mindfulworkout.ui.theme.BackgroundPhotoProfileCard
import com.example.mindfulworkout.ui.theme.RussoOne
import com.example.mindfulworkout.ui.theme.ShapeTopTextMainScreen
import com.example.mindfulworkout.ui.theme.TextColorProfileCard
import com.example.mindfulworkout.viewmodels.MainScreenViewModel
import kotlin.io.encoding.ExperimentalEncodingApi

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    onClickMenuItem: (Int) -> Unit = {},
    mainScreenViewModel: MainScreenViewModel = viewModel(factory = MainScreenViewModel.factory)
) {
    var exercises by remember { mutableIntStateOf(0) } // ESTÁ VARIÁVEL TALVEZ EU POSSA TIRAR DO REMEMBER
    val context = LocalContext.current
    var exerciseName by remember { mutableStateOf("") }
    var weight by remember { mutableStateOf("") }
    var repValue by remember { mutableStateOf("") }
    var setValue by remember { mutableStateOf("") }
    var buttonChecked by remember { mutableStateOf(false) }
    var saved = false

    BaseScaffold(
        onClickMenuItem = onClickMenuItem,
        actions = {
            IconButton(
                onClick = {},
                modifier = Modifier.padding(start = 15.dp, top = 15.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_photo_cam),
                    contentDescription = "Ícone de menu",
                    modifier = Modifier.size(35.dp)
                )
            }
        },
        floatingActionButton = {
            MultiFloatingButton {
                when (it) {
                    "Add" -> {
                        if (saved || exercises == 0) {
                            exercises += 1
                            saved = false
                        } else {
                            Toast.makeText(
                                context,
                                "Salve seus exercícios primeiro",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                    "Delete" -> {}
                    else -> {
                        val allowed = validateFields(
                            buttonChecked,
                            exerciseName,
                            weight,
                            repValue,
                            setValue
                        )

                        if (allowed) {
                            try {
                                val workoutInfo = WorkoutInfo(
                                    exerciseName = exerciseName,
                                    weight = weight,
                                    rep = repValue,
                                    set = setValue
                                )
                                mainScreenViewModel.saveWorkoutInfo(workoutInfo)
                                saved = true
                            } catch (e: Exception) {
                                Toast.makeText(
                                    context,
                                    "Erro ao preparar dados. Erro: $e",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        } else {
                            Toast.makeText(
                                context,
                                "Preencha todos os campos, por favor!",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                }
            }
        }
    ){
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(BackgroundMainScreenGradient)
                .padding(it),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item { ProfileCard() }
            item { BodyImcCalc() }
            item { Spacer(modifier = Modifier.height(16.dp)) }
            items(exercises) {
                ExerciseBox(
                    weight = "",
                    set = "",
                    rep = "",
                    exerciseName = "",
                    onValueExerciseNameChange = { exerciseName = it },
                    onValueWeightChange = { weight = it },
                    onValueRepChange = { repValue = it },
                    onValueSetChange = { setValue = it },
                    selectedButton = { buttonChecked = it }
                )
            }
        }
    }
}

@Composable
fun ProfileCard(user: User = User("John Doe", 25, Gender.MALE, "")) {
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
            Card(
                modifier = Modifier
                    .padding(start = 20.dp, top = 20.dp)
                    .size(90.dp),
                shape = CircleShape,
                colors = CardDefaults.cardColors(BackgroundPhotoProfileCard),
            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center  // Aqui centraliza o conteúdo
                ) {
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
                ),
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


@OptIn(ExperimentalMaterial3Api::class, ExperimentalEncodingApi::class)
@Composable
fun BodyImcCalc() {

    var colorToIMC: Color by remember { mutableStateOf(Color.Unspecified) }
    var isClicked by remember { mutableStateOf(false) }
    var weight by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }
    var height by remember { mutableStateOf("") }
    var isHeightFocused by remember { mutableStateOf(false) }
    var isWeightFocused by remember { mutableStateOf(false) }


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
            shape = com.example.mindfulworkout.ui.theme.CircleShape,
            elevation = CardDefaults.cardElevation(60.dp),
            modifier = Modifier
                .padding(top = 20.dp)
                .size(15.dp)
                .clickable { isClicked = true }
        ) {
            Icon(
                imageVector = Icons.Sharp.Info,
                contentDescription = "Informação sobre IMC",
                tint = Black
            )
        }
    }

    Row(
        modifier = Modifier
            .padding(start = 20.dp, end = 20.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        BoxTextBMI(
            label = {
                if (isWeightFocused || weight.isNotEmpty()) "Weight(kg)"
                else "Weight. Ex: 71.5"

            },
            value = weight,
            onValueChange = { weight = it },
            modifier = Modifier
                .weight(1f)
                .onFocusChanged {
                    isWeightFocused = it.isFocused
                    Log.i("TAG", "Weight: $weight")
                },
        )


        Button(
            onClick = {
                    val imcValue = weight.toDouble() / (height.toDouble() * height.toDouble())
                    val imcFormated = "%.2f".format(imcValue)
                    result = imcFormated.toString()

                    colorToIMC = if (imcValue > 30.0) {
                        Red
                    } else if (imcValue < 18.5) {
                        Yellow
                    } else {
                        Green
                    }
            },
            modifier = Modifier
                .padding(top = 4.dp, start = 5.dp, end = 5.dp)
                .width(87.dp),
            colors = ButtonDefaults.buttonColors(DarkGray)
        ) {
            Text(text = "Calcular", fontSize = 10.sp, color = White)
        }


        BoxTextBMI(
            label = {
                if (isHeightFocused || height.isNotEmpty()) "Height(m)"
                else "Height. Ex: 1.75"
            },
            value = height,
            onValueChange = { height = it },
            modifier = Modifier
                .weight(1f)
                .onFocusChanged {
                    isHeightFocused = it.isFocused
                },
        )
    }


    //Eu n quero ter q usar placeholder e outra pq q height tá tudo normal mas weight n?
    BoxTextBMI(
        label = { "RESULT" },
        value = result,
        onValueChange = { result = it },
        modifier = Modifier
            .width(80.dp)
            .padding(top = 10.dp),
        color = colorToIMC,
        readyOnly = true,
        enabled = false
    )
}


fun validateFields(
    checked: Boolean,
    exerciseName: String,
    weight: String,
    reps: String,
    sets: String,
) = checked
        && exerciseName.isNotEmpty()
        && weight.isNotEmpty()
        && reps.isNotEmpty()
        && sets.isNotEmpty()


@Preview
@Composable
private fun MainScreenPreview() {
    MainScreen()
}