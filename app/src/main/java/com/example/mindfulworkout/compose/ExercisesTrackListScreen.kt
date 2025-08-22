package com.example.mindfulworkout.compose

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Update
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.DarkGray
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mindfulworkout.components.BaseScaffold
import com.example.mindfulworkout.components.ExerciseBox
import com.example.mindfulworkout.funcionalities.MinFabItem
import com.example.mindfulworkout.funcionalities.MultiFloatingButton
import com.example.mindfulworkout.model.WorkoutInfo
import com.example.mindfulworkout.ui.theme.DarkDoubleButtonsListScreen
import com.example.mindfulworkout.ui.theme.DoubleButtonsListScreen
import com.example.mindfulworkout.ui.theme.BackgroundColorCardExercises
import com.example.mindfulworkout.viewmodels.ExercisesTrackListViewModel
import kotlin.collections.listOf

@Composable
fun ExerciseTrackListScreen(
    exerciseListViewModel: ExercisesTrackListViewModel = viewModel( factory = ExercisesTrackListViewModel.factory ),
    onClickCardTitle: () -> Unit,
    onClickMenuItem: (Int) -> Unit
) {
    val exercises = exerciseListViewModel.exercises.collectAsState().value
    var nameToDelete: String = remember { mutableStateListOf("").toString() }

    var leftButtonClicked by remember { mutableStateOf(false) }
    var rightButtonClicked by remember { mutableStateOf(false) }
    var onClickRightButton: () -> Unit = {}
    var onClickLeftButton: () -> Unit = {}
    var textLeftButton by remember { mutableStateOf("") }
    var textRightButton by remember { mutableStateOf("") }


    var colors: Color = DoubleButtonsListScreen
    var colorsLeft: Color = DoubleButtonsListScreen
    val border = if (leftButtonClicked || rightButtonClicked) BorderStroke(1.dp, DarkGray) else null

    if (leftButtonClicked) {
        onClickRightButton = {
            println("Right button clicked")
        }
        textLeftButton = "Cancel"
        textRightButton = "Delete All"
        colorsLeft = DarkDoubleButtonsListScreen
    } else if (rightButtonClicked) {
        onClickLeftButton = {
            exerciseListViewModel.deleteExercise(nameToDelete.toString())
        }
        textLeftButton = "Delete"
        textRightButton = "Cancel"
        colors = DarkDoubleButtonsListScreen
    } else {
        textLeftButton = "Select all"
        textRightButton = "Edit"
    }


    BaseScaffold(
        onClickCardTitle = {
            onClickCardTitle()
        },
        onClickMenuItemBaseSca = onClickMenuItem,
        actions = {
            IconButton(
                onClick = {},
                modifier = Modifier.padding(start = 15.dp, top = 15.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Ícone de menu",
                    modifier = Modifier.size(35.dp)
                )
            }
        },
        floatingActionButton = {
            MultiFloatingButton(
                list = listOf(MinFabItem(Icons.Default.Update, "Update"))
            ) {
                when (it) {
                    "Update" -> {
                        exerciseListViewModel.updateExercise(exercises[0].exerciseName)
                    }
                }
            }
        },
    ) {
        LazyColumn(
            modifier = Modifier.padding(it)
        ) {
            item {
                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 10.dp, end = 10.dp)
                        .background(Transparent)
                        .border(
                            width = 0.dp,
                            color = BackgroundColorCardExercises,
                            shape = CardDefaults.shape
                        )
                ){
                    Button(
                        onClick = {
                            if (rightButtonClicked) {
                                onClickLeftButton()
                            } else {
                                leftButtonClicked = !leftButtonClicked
                                rightButtonClicked = false
                            }
                        },
                        modifier = Modifier.weight(1f),
                        colors = ButtonDefaults.elevatedButtonColors(colorsLeft),
                        border = border,
                        elevation = if (leftButtonClicked) null else ButtonDefaults.elevatedButtonElevation()
                    ) {
                        Icon(
                            imageVector = if (leftButtonClicked) Icons.Default.Close else if (rightButtonClicked) Icons.Default.Delete else Icons.Default.Check,
                            contentDescription = null,
                            tint = Black
                        )
                        Spacer(Modifier.width(8.dp))
                        Text(
                            text = textLeftButton,
                            color = White,
                            fontSize = 14.sp
                        )
                    }


                    Button(
                        onClick = {
                            if (leftButtonClicked) {
                                onClickRightButton()
                            } else {
                                rightButtonClicked = !rightButtonClicked
                                leftButtonClicked = false
                            }
                        },
                        modifier = Modifier.weight(1f),
                        colors = ButtonDefaults.elevatedButtonColors(colors),
                        border = border
                    ) {
                        Icon(
                            imageVector = if (leftButtonClicked) Icons.Default.Delete else if (rightButtonClicked) Icons.Default.Close else Icons.Default.Edit,
                            contentDescription = null,
                            tint = Black
                        )
                        Spacer(Modifier.width(8.dp))
                        Text(
                            text = textRightButton,
                            color = White,
                            fontSize = 14.sp
                        )
                    }
                }
            }
            items(exercises.size) { index ->
                val workout = exercises[index]
                ExerciseBox(
                    readOnly = !rightButtonClicked,
                    onValueExerciseNameChange = {
                        workout.exerciseName
                    },
                    onValueWeightChange = {
                        workout.weight
                    },
                    onValueRepChange = {
                        workout.rep
                    },
                    onValueSetChange = {
                        workout.set
                    },
                    selectedButton = {
                        if (it) {
                            nameToDelete = workout.exerciseName
                        }
                    }
                )
            }
        }
    }
}

@Composable
fun ExerciseTrackCard(workout: WorkoutInfo) {
    Text("${workout.exerciseName} - ${workout.weight} kg - ${workout.rep} repetições - ${workout.set} série")
}

@Preview
@Composable
private fun ExerciseTrackListScreenPreview() {
    ExerciseTrackCard(
        WorkoutInfo(
            exerciseName = "Supino",
            weight = "10",
            rep = "12",
            set = "3"
        )
    )
}
