package com.example.mindfulworkout.compose

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mindfulworkout.components.BaseScaffold

@Composable
fun ExerciseTrackListScreen(
    onValueWeightChange: (String) -> Unit = {},
    onValueRepChange: (String) -> Unit = {},
    onValueSetChange: (String) -> Unit = {},
    onValueExerciseNameChange: (String) -> Unit = {},
    onClickCardTitle: () -> Unit,
) {
    var weight by remember { mutableStateOf("") }
    var exerciseName by remember { mutableStateOf("") }

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
    ) { }

}

@Preview
@Composable
private fun ExerciseTrackListScreenPreview() {
    ExerciseTrackListScreen(onClickCardTitle = {})
}
