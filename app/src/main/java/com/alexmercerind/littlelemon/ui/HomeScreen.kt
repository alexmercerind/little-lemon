package com.alexmercerind.littlelemon.ui

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
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
import androidx.compose.material3.CircularProgressIndicator
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
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
import androidx.lifecycle.viewmodel.compose.viewModel
import com.alexmercerind.littlelemon.R
import com.alexmercerind.littlelemon.db.entities.CacheMenuItem
import com.alexmercerind.littlelemon.ui.theme.HighlightColor0
import com.alexmercerind.littlelemon.ui.theme.LittleLemonTheme
import com.alexmercerind.littlelemon.ui.theme.PrimaryColor0
import com.alexmercerind.littlelemon.utils.Constants
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    val homeScreenViewModel = viewModel<HomeScreenViewModel>()
    var items by rememberSaveable { mutableStateOf<List<CacheMenuItem>?>(null) }

    var term by rememberSaveable { mutableStateOf("") }

    LaunchedEffect("HomeScreen") {
        withContext(Dispatchers.IO) {
            val result = homeScreenViewModel.getMenu()
            items = result
            Log.d(Constants.LOG_TAG, result.toString())
        }
    }

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
                        value = term,
                        onValueChange = { term = it },
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
                    .padding(top = 16.dp, start = 16.dp, end = 16.dp)
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
                        contentColor = PrimaryColor0,
                        modifier = Modifier.clip(RoundedCornerShape(12.dp))
                    ) {
                        Text(
                            text = stringResource(id = res), modifier = Modifier.padding(8.dp)
                        )
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
            }
            Divider(thickness = 1.dp)
            if (items == null) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .weight(1.0F)
                        .fillMaxWidth()
                ) {
                    CircularProgressIndicator()
                }
            } else {
                // Sort & Filter
                val result = items!!
                    .sortedBy { it.title }
                    .filter { it.title.contains(term, ignoreCase = true) }
                LazyColumn(
                    modifier = Modifier
                        .weight(1.0F)
                        .padding(0.dp),
                    contentPadding = PaddingValues(vertical = 8.dp)
                ) {
                    items(result.size) {
                        MenuItemTile(result[it])
                    }
                }
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