package com.example.museoegipto.ui.screens

import kotlinx.serialization.Serializable

@Serializable
sealed class Screen(val route: String) {
    @Serializable
    data object Onboarding: Screen("Onboarding")
    @Serializable
    data object Home: Screen("Home")
    @Serializable
    data object Article: Screen("Article")
}