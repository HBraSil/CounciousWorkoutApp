package com.example.mindfulworkout.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.text.font.FontWeight.Companion.W600
import androidx.compose.ui.text.font.FontWeight.Companion.W900
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mindfulworkout.ui.theme.CircleShape



@Composable
fun RepAndSetItem(
    label: String,
    onValueRepsAndSetsChange: (String) -> Unit = { "" }
) {
    var quantSets by remember { mutableStateOf("") }
    onValueRepsAndSetsChange(quantSets)

    Row(
        modifier = Modifier.height(65.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        FloatingActionButton(
            onClick = {
                if (quantSets != "") {
                    if (quantSets.toInt() > 0) {
                        val result = quantSets.toInt() - 1
                        quantSets = result.toString()
                    }
                }
            },
            shape = CircleShape,
            modifier = Modifier
                .size(35.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Remove,
                contentDescription = "Decrementar Sets",
                modifier = Modifier.size(35.dp),
                tint = Color.Black
            )
        }


        // Texto "SETS"
        OutlinedTextField(
            value = quantSets,
            onValueChange = {
                quantSets = it
            },
            label = {
                Text(
                    text = label,
                    fontSize = 11.sp,
                    color = Gray,
                    fontWeight = W600,
                    maxLines = 1
                )
            },
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier
                .padding(horizontal = 8.dp)
                .width(60.dp)
                .align(Alignment.Top),
            textStyle = androidx.compose.ui.text.TextStyle(
                fontSize = 14.sp,
                color = Gray,
                fontWeight = W900
            ),
            singleLine = true,
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White
            ),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            )
        )


        // Botão Incrementar
        FloatingActionButton(
            onClick = {
                if (quantSets == "") quantSets = "0"
                val result = quantSets.toInt() + 1
                quantSets = result.toString()
            },
            shape = CircleShape,
            modifier = Modifier
                .size(35.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "Decrementar Sets",
                modifier = Modifier.size(35.dp),
                tint = Color.Black
            )
        }
    }
}



@Preview(showBackground = true)
@Composable
private fun SetAnpreview() {
    RepAndSetItem("Sets")
}