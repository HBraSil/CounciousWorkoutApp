package com.example.mindfulworkout.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mindfulworkout.components.BaseScaffold
import com.example.mindfulworkout.components.ExerciseBox
import com.example.mindfulworkout.components.ExerciseItemPreview
import com.example.mindfulworkout.model.WorkoutInfo
import com.example.mindfulworkout.viewmodels.ExercisesTrackListViewModel

@Composable
fun ExerciseTrackListScreen(
    exerciseListViewModel: ExercisesTrackListViewModel = viewModel( factory = ExercisesTrackListViewModel.factory ),
    onClickCardTitle: () -> Unit
) {
    val exercises = exerciseListViewModel.exercises.collectAsState().value


    BaseScaffold(
        onClickCardTitle = {
            onClickCardTitle()
        },
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
        }
    ) {


        LazyColumn(
            modifier = Modifier.padding(it)
        ) {
            item {
                Spacer(Modifier.width(23.dp))
                Icon (
                    imageVector = Icons.Default.Edit,
                    contentDescription = "Ícone de menu",
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(White)
                )
            }
            items(exercises.size) { index ->
                val workout = exercises[index]
                ExerciseBox(
                    weight = workout.weight,
                    set = workout.set,
                    rep = workout.rep,
                    exerciseName = workout.exerciseName
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
