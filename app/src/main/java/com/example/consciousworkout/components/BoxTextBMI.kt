package com.example.consciousworkout.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun BoxTextBMI(
    modifier: Modifier = Modifier,
    value: String? = null,
    onValueChange: (String) -> Unit = {},
    label: String,
) {

    OutlinedTextField(
        value.toString(),
        onValueChange,
        label = { Text(text = label) },
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        modifier = modifier,
        colors = OutlinedTextFieldDefaults.colors(
            focusedTextColor = White,
            focusedContainerColor = Black,
            unfocusedContainerColor = Black,
            unfocusedTextColor = White,
            cursorColor = White,
            focusedBorderColor = White,
            focusedLabelColor = White
        ),
        shape = RoundedCornerShape(8.dp)

    )

}

@Preview
@Composable
private fun BoxTextBMIPreview() {
    BoxTextBMI(
        label = "Kg",
        )
}