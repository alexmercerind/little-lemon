package com.alexmercerind.littlelemon.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.alexmercerind.littlelemon.db.entities.CacheMenuItem
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun MenuItemTile(cacheMenuItem: CacheMenuItem) {
    return Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(140.dp)
            .padding(16.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = cacheMenuItem.title,
            style = MaterialTheme.typography.bodyLarge,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        Row(
            verticalAlignment = Alignment.Top,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            Column(modifier = Modifier.weight(1.0F)) {
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = cacheMenuItem.description,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.wrapContentSize(Alignment.Center),
                    style = MaterialTheme.typography.bodyMedium
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "$ ${cacheMenuItem.price.toDouble()}",
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.wrapContentSize(Alignment.Center),
                    style = MaterialTheme.typography.titleSmall
                )
                Spacer(modifier = Modifier.height(8.dp))
            }
            Spacer(modifier = Modifier.width(8.dp))
            GlideImage(
                model = cacheMenuItem.image,
                contentDescription = cacheMenuItem.title,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxHeight()
                    .aspectRatio(1.0F),
            )
        }
    }
}
