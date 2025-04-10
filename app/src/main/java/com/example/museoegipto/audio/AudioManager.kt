package com.example.museoegipto.audio

import android.content.Context
import androidx.media3.common.MediaItem
import androidx.media3.common.Player
import androidx.media3.exoplayer.ExoPlayer
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

object AudioManager {
    private var audioPlayer: ExoPlayer? = null
    private var currentAudioResource: Int? = null
    private var isPlaying = false
    
    private val _isAudioEnabled = MutableStateFlow(true)
    val isAudioEnabled: StateFlow<Boolean> = _isAudioEnabled.asStateFlow()
    
    fun getAudioPlayer(context: Context): ExoPlayer {
        if (audioPlayer == null) {
            audioPlayer = ExoPlayer.Builder(context).build().apply {
                repeatMode = Player.REPEAT_MODE_ALL
                playWhenReady = true
            }
        }
        return audioPlayer!!
    }
    
    fun setAudioResource(context: Context, audioResourceId: Int) {
        if (currentAudioResource == audioResourceId && isPlaying) return
        
        val player = getAudioPlayer(context)
        val mediaItem = MediaItem.fromUri("android.resource://${context.packageName}/$audioResourceId")
        player.setMediaItem(mediaItem)
        player.prepare()
        currentAudioResource = audioResourceId
        isPlaying = true
    }
    
    fun stopAudio() {
        audioPlayer?.stop()
        currentAudioResource = null
        isPlaying = false
    }
    
    fun pauseAudio() {
        audioPlayer?.pause()
        isPlaying = false
    }
    
    fun resumeAudio() {
        audioPlayer?.play()
        isPlaying = true
    }
    
    fun toggleAudio() {
        _isAudioEnabled.value = !_isAudioEnabled.value
        if (_isAudioEnabled.value) {
            resumeAudio()
        } else {
            pauseAudio()
        }
    }
    
    fun releaseAudioPlayer() {
        audioPlayer?.release()
        audioPlayer = null
        currentAudioResource = null
        isPlaying = false
    }

    fun pauseForVideo() {
        if (isPlaying) {
            pauseAudio()
        }
    }

    fun resumeAfterVideo() {
        if (_isAudioEnabled.value) {
            resumeAudio()
        }
    }
} 