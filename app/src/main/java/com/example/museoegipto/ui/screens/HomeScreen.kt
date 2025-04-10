package com.example.museoegipto.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose.MuseoEgiptoTheme
import com.example.museoegipto.R
import com.example.museoegipto.audio.AudioManager
import com.example.museoegipto.data.DataSource
import com.example.museoegipto.model.AgeGroup
import com.example.museoegipto.model.Article
import com.example.museoegipto.model.Section
import com.example.museoegipto.ui.components.ArticleCard
import com.example.museoegipto.ui.components.SettingsDialog
import com.example.museoegipto.ui.theme.LordStoryFontFamily
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    textScale: Float = 1f,
    onTextScaleChange: (Float) -> Unit = {},
    isHighContrast: Boolean = false,
    onHighContrastChange: (Boolean) -> Unit = {},
    selectedAgeGroup: AgeGroup = AgeGroup.ADULT,
    onAgeGroupSelected: (AgeGroup) -> Unit = {},
    onArticleClick: (Article) -> Unit = {},
) {
    val context = LocalContext.current
    var selectedSection by rememberSaveable { mutableStateOf(Section.DAILY_LIFE) }
    var showSettingsDialog by remember { mutableStateOf(false) }
    val isAudioEnabled by AudioManager.isAudioEnabled.collectAsState()

    val pagerState = rememberPagerState(initialPage = when (selectedSection) {
        Section.DAILY_LIFE -> 0
        Section.ARCHITECTURE -> 1
        Section.ART -> 2
    }) { 3 }
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(isAudioEnabled) {
        if (isAudioEnabled) {
            AudioManager.setAudioResource(context, R.raw.egypt)
        }
    }

    LaunchedEffect(selectedSection) {
        coroutineScope.launch {
            pagerState.animateScrollToPage(
                when (selectedSection) {
                    Section.DAILY_LIFE -> 0
                    Section.ARCHITECTURE -> 1
                    Section.ART -> 2
                }
            )
        }
    }

    Scaffold(
        modifier = modifier,
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        "Antiguo Egipto",
                        style = MaterialTheme.typography.titleLarge.copy(
                            fontSize = MaterialTheme.typography.titleLarge.fontSize * textScale,
                            fontFamily = LordStoryFontFamily
                        ),
                        maxLines = 2,
                        textAlign = TextAlign.Center
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.secondary,
                    titleContentColor = MaterialTheme.colorScheme.onSecondary
                ),
                actions = {
                    IconButton(
                        onClick = { AudioManager.toggleAudio() }
                    ) {
                        Icon(
                            if (isAudioEnabled) painterResource(R.drawable.volume_up) else painterResource(
                                R.drawable.volume_off
                            ),
                            contentDescription = if (isAudioEnabled) "Silenciar audio" else "Activar audio",
                            tint = MaterialTheme.colorScheme.onSecondary
                        )
                    }
                    IconButton(onClick = { showSettingsDialog = true }) {
                        Icon(
                            Icons.Default.Settings,
                            contentDescription = "Configuración",
                            tint = MaterialTheme.colorScheme.onSecondary
                        )
                    }
                }
            )
        },
        bottomBar = {
            NavigationBar {
                Section.entries.forEach { section ->
                    NavigationBarItem(
                        selected = selectedSection == section,
                        onClick = { selectedSection = section },
                        icon = {
                            Icon(
                                when (section) {
                                    Section.DAILY_LIFE -> painterResource(R.drawable.home)
                                    Section.ARCHITECTURE -> painterResource(R.drawable.architecture)
                                    Section.ART -> painterResource(R.drawable.palette)
                                },
                                contentDescription = section.name,
                                modifier = Modifier.size(32.dp)
                            )
                        },
                        label = {
                            Text(
                                section.title,
                                style = MaterialTheme.typography.labelSmall.copy(
                                    fontSize = MaterialTheme.typography.labelSmall.fontSize * textScale,
                                ),
                            )
                        },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = MaterialTheme.colorScheme.onSecondary,
                            unselectedIconColor = MaterialTheme.colorScheme.secondary,
                            selectedTextColor = MaterialTheme.colorScheme.secondary,
                            unselectedTextColor = MaterialTheme.colorScheme.secondary,
                            indicatorColor = MaterialTheme.colorScheme.secondary
                        ),
                    )
                }
            }
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Box(
                modifier = Modifier.fillMaxSize()
            ) {
                Image(
                    painter = painterResource(R.drawable.fondo),
                    contentScale = ContentScale.Crop,
                    contentDescription = "Fondo de pantalla de jeroglificos",
                    modifier = Modifier.fillMaxSize()
                )
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Black.copy(alpha = 0.3f))
                )
            }
            HorizontalPager(
                state = pagerState,
                userScrollEnabled = false,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) { page ->
                val section = when (page) {
                    0 -> Section.DAILY_LIFE
                    1 -> Section.ARCHITECTURE
                    else -> Section.ART
                }
                val articles = DataSource.getArticlesBySection(section, selectedAgeGroup)
                ArticlesList(
                    articles = articles,
                    textScale = textScale,
                    onArticleClick = onArticleClick
                )
            }

            if (showSettingsDialog) {
                SettingsDialog(
                    textScale = textScale,
                    onTextScaleChange = onTextScaleChange,
                    isHighContrast = isHighContrast,
                    onHighContrastChange = onHighContrastChange,
                    selectedAgeGroup = selectedAgeGroup,
                    onAgeGroupSelected = onAgeGroupSelected,
                    onDismiss = { showSettingsDialog = false }
                )
            }
        }
    }
}

@Preview
@Composable
private fun HomeScreenPreview() {
    MuseoEgiptoTheme {
        HomeScreen()
    }
}

@Composable
private fun ArticlesList(
    articles: List<Article>,
    textScale: Float,
    onArticleClick: (Article) -> Unit,
) {
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        LazyColumn(
            state = listState,
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(articles) { article ->
                ArticleCard(
                    article = article,
                    textScale = textScale,
                    onClick = { onArticleClick(article) },
                )
            }
        }

        Column(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            FloatingActionButton(
                onClick = {
                    coroutineScope.launch {
                        val currentIndex = listState.firstVisibleItemIndex
                        if (currentIndex > 0) {
                            listState.animateScrollToItem(currentIndex - 1)
                        }
                    }
                },
                containerColor = MaterialTheme.colorScheme.primaryContainer
            ) {
                Icon(
                    Icons.Default.KeyboardArrowUp,
                    contentDescription = "Desplazar lista hacia arriba",
                    tint = MaterialTheme.colorScheme.onPrimaryContainer
                )
            }

            FloatingActionButton(
                onClick = {
                    coroutineScope.launch {
                        val currentIndex = listState.firstVisibleItemIndex
                        if (currentIndex < articles.size - 1) {
                            listState.animateScrollToItem(currentIndex + 1)
                        }
                    }
                },
                containerColor = MaterialTheme.colorScheme.primaryContainer
            ) {
                Icon(
                    Icons.Default.KeyboardArrowDown,
                    contentDescription = "Desplazar lista hacia abajo",
                    tint = MaterialTheme.colorScheme.onPrimaryContainer
                )
            }
        }
    }
}
