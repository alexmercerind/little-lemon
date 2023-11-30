package com.alexmercerind.littlelemon.ui

import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alexmercerind.littlelemon.R
import com.alexmercerind.littlelemon.ui.theme.LittleLemonTheme
import com.alexmercerind.littlelemon.ui.theme.PrimaryColor1
import com.alexmercerind.littlelemon.ui.theme.SecondaryColor0

@Composable
fun PrimaryButton(@StringRes text: Int, modifier: Modifier = Modifier, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = modifier,
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(1.dp, SecondaryColor0),
        colors = ButtonDefaults.buttonColors(
            containerColor = PrimaryColor1,
            contentColor = Color(0xFF000000)
        )
    ) {
        Text(
            text = stringResource(id = text),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Preview
@Composable
fun PrimaryButtonPreview() {
    LittleLemonTheme {
        PrimaryButton(text = R.string.register) {}
    }
}
