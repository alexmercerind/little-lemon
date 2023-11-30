package com.alexmercerind.littlelemon.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alexmercerind.littlelemon.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PrimaryTopAppBar(showProfileIcon: Boolean = false) {
    TopAppBar(
        title = {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = stringResource(id = R.string.app_name),
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(vertical = 12.dp)
            )
        },
        actions = {
            if (showProfileIcon)
                IconButton(onClick = { /*TODO*/ }) {
                    Image(
                        painter = painterResource(id = R.drawable.profile),
                        contentDescription = stringResource(id = R.string.app_name),
                        modifier = Modifier
                            .fillMaxHeight()
                            .aspectRatio(1.0F)
                    )
                }
        },
        modifier = Modifier.padding(0.dp)
    )
}

@Preview
@Composable
fun PrimaryTopAppBarPreviewHideProfileIcon() {
    PrimaryTopAppBar(showProfileIcon = false)
}

@Preview
@Composable
fun PrimaryTopAppBarPreviewShowProfileIcon() {
    PrimaryTopAppBar(showProfileIcon = true)
}
