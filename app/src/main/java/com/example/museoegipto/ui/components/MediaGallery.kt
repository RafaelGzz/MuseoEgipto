package com.example.museoegipto.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.museoegipto.model.MediaItem
import kotlinx.coroutines.launch

@Composable
fun MediaGallery(images: List<MediaItem>, modifier: Modifier = Modifier) {
    val pagerState = rememberPagerState { images.size }
    val coroutineScope = rememberCoroutineScope()
    Column(modifier) {
        Box {
            HorizontalPager(
                state = pagerState,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            ) { page ->
                Image(
                    painterResource(images[page].id!!),
                    contentDescription = images[page].description,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }
            if (pagerState.currentPage > 0)
                IconButton(
                    colors = IconButtonDefaults.iconButtonColors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainer,
                    ),
                    modifier = Modifier.align(Alignment.CenterStart),
                    onClick = { coroutineScope.launch { pagerState.animateScrollToPage(page = pagerState.currentPage - 1) } }
                ) {
                    Icon(
                        Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                        contentDescription = "Previous Image",
                        tint = MaterialTheme.colorScheme.onSurface
                    )
                }
            if (pagerState.currentPage < images.size - 1)
                IconButton(
                    colors = IconButtonDefaults.iconButtonColors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainer,
                    ),
                    modifier = Modifier.align(Alignment.CenterEnd),
                    onClick = { coroutineScope.launch { pagerState.animateScrollToPage(page = pagerState.currentPage + 1) } }
                ) {
                    Icon(
                        Icons.AutoMirrored.Filled.KeyboardArrowRight,
                        contentDescription = "Next Image",
                        tint = MaterialTheme.colorScheme.onSurface
                    )
                }
        }
    }
}