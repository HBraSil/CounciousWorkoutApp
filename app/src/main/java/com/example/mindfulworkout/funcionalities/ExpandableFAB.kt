package com.example.mindfulworkout.funcionalities

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.updateTransition
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex


data class MinFabItem(
    var icon: ImageVector,
    var name: String,
)


@Composable
fun MultiFloatingButton(onClick: (String) -> Unit) {
    var expanded by remember { mutableStateOf(false) }
    val list = listOf(
        MinFabItem(Icons.Default.Delete, "Delete"),
        MinFabItem(Icons.Default.Done, "Save"),
        MinFabItem(Icons.Default.Add, "Add")
    )

    Column(horizontalAlignment = Alignment.End) {
        AnimatedVisibility(
            visible = expanded,
            enter = fadeIn() + slideInVertically(initialOffsetY = { it }) + expandVertically(),
            exit = fadeOut() + slideOutVertically(targetOffsetY = { it }) + shrinkVertically(),
            modifier = Modifier.zIndex(1f)
        ) {
            Column(
                modifier = Modifier.wrapContentHeight() // <-- ISSO AQUI É FUNDAMENTAL
            ) {
                list.forEach { item ->
                    MinFab(item) {
                        onClick(item.name)
                    }
                }
            }
        }


        val transition = updateTransition(targetState = expanded, label = "transition")
        val rotate by transition.animateFloat(label = "rotate") {
            if (it) 90f else 0f
        }

        FloatingActionButton(
            onClick = { expanded = !expanded }
        ) {
            Icon(
                imageVector = if (expanded) Icons.Filled.Close else Icons.Default.MoreVert,
                contentDescription = "Adicionar",
                modifier = Modifier.rotate(rotate)
            )
        }
    }
}


@Composable
fun MinFab(item: MinFabItem, onClick: (String) -> Unit = {}) {

    Row(
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Spacer(Modifier.weight(1f))
        Box(
            modifier = Modifier
                .border(2.dp, Black, RoundedCornerShape(6.dp))
                .padding(4.dp)
                .wrapContentWidth(),
        ) {
            Text(item.name, modifier = Modifier.wrapContentWidth())
        }


        FloatingActionButton(
            onClick = {
                when(item.name) {
                    "Add" -> onClick("Add")
                    "Delete" -> onClick("Delete")
                    else -> onClick("Save")
                }
            },
            modifier = Modifier
                .padding(start = 10.dp, bottom = 7.dp)
                .size(40.dp)
        ) {
            Icon(
                imageVector = item.icon,
                contentDescription = item.name,
            )
        }
    }
}


