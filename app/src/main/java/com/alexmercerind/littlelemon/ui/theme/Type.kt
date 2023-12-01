package com.alexmercerind.littlelemon.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.alexmercerind.littlelemon.R

val Typography = Typography(
    displayLarge = TextStyle(
        color = PrimaryColor1,
        fontSize = 56.sp,
        letterSpacing = 2.sp,
        fontWeight = FontWeight.Bold,
        fontFamily = FontFamily(listOf(Font(R.font.markazi_text)))
    ),
    displayMedium = TextStyle(
        color = HighlightColor0,
        fontSize = 40.sp,
        fontWeight = FontWeight.Normal,
        fontFamily = FontFamily(listOf(Font(R.font.markazi_text)))
    ),
    displaySmall = TextStyle(
        color = HighlightColor0,
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold,
        fontFamily = FontFamily(listOf(Font(R.font.karla)))
    ),
    headlineMedium = TextStyle(
        fontSize = 28.sp,
        fontWeight = FontWeight.Normal,
        fontFamily = FontFamily(listOf(Font(R.font.karla)))
    ),
    titleLarge = TextStyle(
        fontSize = 20.sp,
        fontWeight = FontWeight.Black,
        fontFamily = FontFamily(listOf(Font(R.font.karla)))
    ),
    titleMedium = TextStyle(
        color = HighlightColor1,
        fontSize = 20.sp,
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
