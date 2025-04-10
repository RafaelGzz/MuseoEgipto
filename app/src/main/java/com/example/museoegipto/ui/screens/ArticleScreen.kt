package com.example.museoegipto.ui.screens

import android.content.Context
import android.content.pm.ActivityInfo
import android.os.Build
import androidx.activity.compose.BackHandler
import androidx.activity.compose.LocalActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.compose.ui.window.DialogProperties
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.media3.common.MediaItem
import androidx.media3.common.Player
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
import com.example.museoegipto.MainActivity
import com.example.museoegipto.R
import com.example.museoegipto.audio.AudioManager
import com.example.museoegipto.model.Article
import com.example.museoegipto.ui.theme.LordStoryFontFamily
import kotlin.math.roundToInt

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ArticleScreen(
    article: Article,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
    textScale: Float = 1f
) {
    val context = LocalContext.current
    var showVideo by rememberSaveable { mutableStateOf(false) }
    var isFullScreen by rememberSaveable { mutableStateOf(false) }
    var selectedImageIndex by rememberSaveable { mutableStateOf<Int?>(null) }
    var scale by remember { mutableStateOf(1f) }
    var offset by remember { mutableStateOf(IntOffset.Zero) }
    val isAudioEnabled by AudioManager.isAudioEnabled.collectAsState()

    LaunchedEffect(isAudioEnabled) {
        if (article.audio.id != null && isAudioEnabled) {
            AudioManager.setAudioResource(context, article.audio.id)
        }
    }

    val activity = LocalActivity.current as MainActivity
    val paragraphs = rememberSaveable(article) { article.content.split("/") }
    val images = rememberSaveable(article) { article.images }

    BackHandler {
        if (showVideo) {
            showVideo = false
            activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED
            showSystemUi(activity)
        } else {
            onBackClick()
        }
    }

    if (showVideo && article.video.id != null) {
        Surface(
            modifier = modifier.fillMaxSize(),
            color = Color.Black
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .then(if (!isFullScreen) Modifier.statusBarsPadding() else Modifier),
                contentAlignment = Alignment.Center
            ) {
                VideoPlayer(
                    videoId = article.video.id,
                    onFullScreenButtonClick = { fullScreen ->
                        isFullScreen = fullScreen
                        if (fullScreen) {
                            activity.requestedOrientation =
                                ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
                            hideSystemUi(activity)
                        } else {
                            activity.requestedOrientation =
                                ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED
                            showSystemUi(activity)
                        }
                    },
                    onPlaybackEnded = {
                        showVideo = false
                        isFullScreen = false
                        activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED
                        showSystemUi(activity)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                )

                IconButton(
                    onClick = {
                        showVideo = false
                        isFullScreen = false
                        activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED
                        showSystemUi(activity)
                    },
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(16.dp)
                ) {
                    Icon(
                        Icons.Default.Close,
                        contentDescription = "Cerrar video",
                        tint = Color.White
                    )
                }
            }
        }
    } else {
        Scaffold(
            modifier = modifier,
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            article.title,
                            style = MaterialTheme.typography.titleLarge.copy(
                                fontSize = MaterialTheme.typography.titleLarge.fontSize * textScale,
                                textAlign = TextAlign.Center,
                                fontFamily = LordStoryFontFamily
                            ),
                            modifier = Modifier.fillMaxWidth()
                        )
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.secondary,
                        titleContentColor = MaterialTheme.colorScheme.onSecondary
                    ),
                    navigationIcon = {
                        IconButton(onClick = onBackClick) {
                            Icon(
                                Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = "Regresar a pantalla principal",
                                tint = MaterialTheme.colorScheme.onSecondary
                            )
                        }
                    },
                    actions = {
                        if (article.audio.id != null) {
                            IconButton(onClick = { AudioManager.toggleAudio() }) {
                                Icon(
                                    if (isAudioEnabled) painterResource(R.drawable.volume_up)
                                    else painterResource(R.drawable.volume_off),
                                    contentDescription = if (isAudioEnabled) "Silenciar audio" else "Activar audio",
                                    tint = MaterialTheme.colorScheme.onSecondary
                                )
                            }
                        }
                    }
                )
            },
            floatingActionButton = {
                if (article.video.id != null) {
                    ExtendedFloatingActionButton(
                        onClick = {
                            showVideo = true
                        },
                        containerColor = MaterialTheme.colorScheme.primaryContainer
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(8.dp),
                        ) {
                            Icon(
                                Icons.Default.PlayArrow,
                                contentDescription = "Ver video",
                            )
                            Text(
                                "Ver Video",
                                style = MaterialTheme.typography.labelLarge.copy(
                                    fontSize = MaterialTheme.typography.labelLarge.fontSize * textScale,
                                )
                            )
                        }
                    }
                }
            }
        ) { paddingValues ->
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                paragraphs.forEachIndexed { index, paragraph ->
                    if (index < images.size) {
                        item {
                            Image(
                                painter = painterResource(images[index].id!!),
                                contentScale = ContentScale.Crop,
                                contentDescription = images[index].description,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(200.dp)
                                    .padding(horizontal = 16.dp, vertical = 8.dp)
                                    .clickable { selectedImageIndex = index }
                            )
                        }
                    }
                    item {
                        Text(
                            text = paragraph.trim(),
                            style = MaterialTheme.typography.bodyMedium.copy(
                                fontSize = MaterialTheme.typography.bodyMedium.fontSize * textScale,
                                lineHeight = MaterialTheme.typography.bodyMedium.lineHeight * textScale
                            ),
                            textAlign = TextAlign.Justify,
                            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                        )
                    }
                }
                item {
                    Spacer(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(64.dp)
                    )
                }
            }
        }
    }

    if (selectedImageIndex != null) {
        BasicAlertDialog(
            onDismissRequest = {
                selectedImageIndex = null
                scale = 1f
                offset = IntOffset.Zero
            },
            properties = DialogProperties(
                dismissOnBackPress = true,
                dismissOnClickOutside = true,
                usePlatformDefaultWidth = false
            )
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.7f))
                    .pointerInput(Unit) {
                        detectTransformGestures { _, pan, zoom, _ ->
                            scale = (scale * zoom).coerceIn(1f, 5f)
                            offset = IntOffset(
                                (offset.x + pan.x).roundToInt(),
                                (offset.y + pan.y).roundToInt()
                            )
                        }
                    }
            ) {
                Image(
                    painter = painterResource(images[selectedImageIndex!!].id!!),
                    contentDescription = images[selectedImageIndex!!].description,
                    modifier = Modifier
                        .fillMaxSize()
                        .graphicsLayer(
                            scaleX = scale,
                            scaleY = scale,
                            translationX = offset.x.toFloat(),
                            translationY = offset.y.toFloat()
                        ),
                    contentScale = ContentScale.Inside
                )

                FloatingActionButton(
                    onClick = {
                        selectedImageIndex = null
                        scale = 1f
                        offset = IntOffset.Zero
                    },
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(16.dp),
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                ) {
                    Icon(
                        Icons.Default.Close,
                        contentDescription = "Cerrar imagen",
                        tint = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                }
            }
        }
    }
}

@Composable
fun VideoPlayer(
    videoId: Int,
    onFullScreenButtonClick: (Boolean) -> Unit,
    onPlaybackEnded: () -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current

    val exoPlayer = remember {
        ExoPlayerManager.getExoPlayer(context).apply {
            val mediaItem = MediaItem.fromUri("android.resource://${context.packageName}/$videoId")
            setMediaItem(mediaItem)
            playWhenReady = true
            prepare()
            AudioManager.pauseForVideo()
            addListener(object : Player.Listener {
                override fun onPlayWhenReadyChanged(playWhenReady: Boolean, reason: Int) {
                    if (playWhenReady) {
                        AudioManager.pauseForVideo()
                    } else {
                        AudioManager.resumeAfterVideo()
                    }
                }

                override fun onPlaybackStateChanged(playbackState: Int) {
                    if (playbackState == Player.STATE_ENDED) {
                        onPlaybackEnded()
                        AudioManager.resumeAfterVideo()
                    }
                }
            })
        }
    }

    Box(modifier = modifier) {
        AndroidView(
            factory = { ctx ->
                PlayerView(ctx).apply {
                    player = exoPlayer
                    exoPlayer.repeatMode = Player.REPEAT_MODE_OFF
                    useController = true
                    setFullscreenButtonClickListener { isFullScreen ->
                        onFullScreenButtonClick(isFullScreen)
                    }
                    if (Build.VERSION.SDK_INT >= 29) {
                        transitionAlpha = 0.5f
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Black)
        )
    }

    DisposableEffect(Unit) {
        onDispose {
            AudioManager.resumeAfterVideo()
            ExoPlayerManager.releaseExoPlayer()
        }
    }
}

private fun hideSystemUi(activity: MainActivity) {
    val window = activity.window ?: return
    WindowCompat.setDecorFitsSystemWindows(window, false)
    WindowInsetsControllerCompat(window, window.decorView).let { controller ->
        controller.hide(WindowInsetsCompat.Type.systemBars())
        controller.systemBarsBehavior =
            WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
    }
}

private fun showSystemUi(activity: MainActivity) {
    val window = activity.window ?: return
    WindowCompat.setDecorFitsSystemWindows(window, true)
    WindowInsetsControllerCompat(
        window,
        window.decorView
    ).show(WindowInsetsCompat.Type.systemBars())
}

object ExoPlayerManager {
    private var exoPlayer: ExoPlayer? = null
    fun getExoPlayer(context: Context): ExoPlayer {
        if (exoPlayer == null) {
            exoPlayer = ExoPlayer.Builder(context).build()
        }
        return exoPlayer!!
    }

    fun releaseExoPlayer() {
        exoPlayer?.release()
        exoPlayer = null
    }
}