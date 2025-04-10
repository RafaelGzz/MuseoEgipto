package com.example.museoegipto.model

data class Article(
    val id: String,
    val title: String,
    val content: String,
    val images: List<MediaItem>,
    val audio: MediaItem,
    val video: MediaItem,
    val ageGroup: AgeGroup,
    val audioDescription: String
) 