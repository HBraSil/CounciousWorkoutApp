package com.example.mindfulworkout.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mindfulworkout.ui.theme.BackgroundMainScreenProfileCard
import com.example.mindfulworkout.ui.theme.BackgroundPhotoProfileCard

@Composable
fun BoxTextBMI(
    modifier: Modifier = Modifier,
    value: String? = null,
    onValueChange: (String) -> Unit = {},
    label: () -> String = { "" },
    color: Color = Gray,
    readyOnly: Boolean = false,
    enabled: Boolean = true,
) {
    OutlinedTextField(
        value = value.toString(),
        onValueChange = onValueChange,
        label = { Text(text = label(), fontSize = 12.sp, maxLines = 1) },
        singleLine = true,
        enabled = enabled,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        modifier = modifier,
        colors = OutlinedTextFieldDefaults.colors(
            focusedTextColor = White,
            focusedContainerColor = BackgroundMainScreenProfileCard,
            unfocusedContainerColor = BackgroundPhotoProfileCard,
            unfocusedTextColor = White,
            cursorColor = White,
            focusedBorderColor = White,
            unfocusedBorderColor = White,
            focusedLabelColor = White,
            unfocusedLabelColor = Black,
            disabledBorderColor = color,
            disabledContainerColor = BackgroundPhotoProfileCard,
            disabledTextColor = Black,
            disabledLabelColor = Black
        ),
        shape = RoundedCornerShape(8.dp),
        readOnly = readyOnly
    )
}


@Preview
@Composable
private fun BoxTextBMIPreview() {
    BoxTextBMI(
        //label = "Kg",
        )
}