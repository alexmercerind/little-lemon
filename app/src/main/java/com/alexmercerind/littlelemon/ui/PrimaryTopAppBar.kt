package com.alexmercerind.littlelemon.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.alexmercerind.littlelemon.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PrimaryTopAppBar(navController: NavController, showProfileIcon: Boolean = false) {
    val width = LocalConfiguration.current.screenWidthDp - 64.0
    TopAppBar(
        title = {
            Row(modifier = Modifier.width(width.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = stringResource(id = R.string.app_name),
                    modifier = Modifier
                        .height(40.dp)
                        .fillMaxWidth()
                )
            }
        },
        actions = {
            if (showProfileIcon) IconButton(onClick = { navController.navigate(Profile.route) }) {
                Image(
                    painter = painterResource(id = R.drawable.profile),
                    contentDescription = stringResource(id = R.string.app_name),
                    modifier = Modifier
                        .fillMaxHeight()
                        .aspectRatio(1.0F)
                )
            }
        },
    )
}
