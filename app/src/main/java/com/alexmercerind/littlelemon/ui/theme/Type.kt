package com.alexmercerind.littlelemon.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.alexmercerind.littlelemon.R

val Typography = Typography(
    headlineMedium = TextStyle(
        fontSize = 28.sp,
        fontWeight = FontWeight.Normal,
        fontFamily = FontFamily(listOf(Font(R.font.karla)))
    ),
    titleLarge = TextStyle(
        color = HighlightColor1,
        fontSize = 24.sp,
        fontWeight = FontWeight.ExtraBold,
        fontFamily = FontFamily(listOf(Font(R.font.karla)))
    ),
    bodyLarge = TextStyle(
        fontSize = 16.sp,
        fontWeight = FontWeight.ExtraBold,
        fontFamily = FontFamily(listOf(Font(R.font.karla)))
    ),
    bodyMedium = TextStyle(
        color = HighlightColor1,
        fontSize = 14.sp,
        fontWeight = FontWeight.Normal,
        fontFamily = FontFamily(listOf(Font(R.font.karla)))
    )
)
