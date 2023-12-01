package com.alexmercerind.littlelemon.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alexmercerind.littlelemon.R
import com.alexmercerind.littlelemon.ui.theme.HighlightColor0
import com.alexmercerind.littlelemon.ui.theme.HighlightColor1
import com.alexmercerind.littlelemon.ui.theme.LittleLemonTheme
import com.alexmercerind.littlelemon.ui.theme.PrimaryColor0

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    Scaffold(topBar = { PrimaryTopAppBar() }) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxHeight()
                .fillMaxWidth()
        ) {
            Surface(
                color = PrimaryColor0, modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                ) {
                    Text(
                        text = stringResource(id = R.string.app_name),
                        style = MaterialTheme.typography.displayLarge
                    )
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(modifier = Modifier.weight(1.0F)) {
                            Text(
                                text = stringResource(id = R.string.subheading),
                                style = MaterialTheme.typography.displayMedium
                            )
                            Text(
                                text = stringResource(id = R.string.about),
                                style = MaterialTheme.typography.displaySmall
                            )
                        }
                        Spacer(modifier = Modifier.width(4.dp))
                        Image(
                            painter = painterResource(id = R.drawable.hero_image),
                            contentDescription = stringResource(id = R.string.app_name),
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .weight(0.5F)
                                .aspectRatio(1.0F)
                                .clip(RoundedCornerShape(12.dp))
                                .clipToBounds()
                        )
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    TextField(
                        placeholder = {
                            Text(text = stringResource(id = R.string.search_placeholder))
                        },
                        value = "",
                        onValueChange = {},
                        shape = RoundedCornerShape(12.dp),
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Search,
                                contentDescription = stringResource(id = R.string.search)
                            )
                        },
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = HighlightColor0,
                            unfocusedIndicatorColor = Color(0x00000000),
                            focusedIndicatorColor = Color(0x00000000)
                        ),
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = stringResource(id = R.string.delivery_text),
                    style = MaterialTheme.typography.titleLarge.copy(color = Color(0xFF000000))
                )
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    for (res in listOf(
                        R.string.menu_section_button_0,
                        R.string.menu_section_button_1,
                        R.string.menu_section_button_2,
                        R.string.menu_section_button_3
                    )) Surface(
                        color = HighlightColor0,
                        contentColor = HighlightColor1,
                        modifier = Modifier.clip(RoundedCornerShape(12.dp))
                    ) {
                        Text(
                            text = stringResource(id = res), modifier = Modifier.padding(10.dp)
                        )
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
                Divider()
            }
            LazyColumn(
                modifier = Modifier.weight(0.5F)
            ) {

            }
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    LittleLemonTheme {
        HomeScreen()
    }
}