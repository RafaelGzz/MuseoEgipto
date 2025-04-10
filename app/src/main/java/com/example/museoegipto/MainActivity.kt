package com.example.museoegipto

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.compose.MuseoEgiptoTheme
import com.example.compose.highContrastLightColorScheme
import com.example.compose.lightScheme
import com.example.museoegipto.model.AgeGroup
import com.example.museoegipto.model.Article
import com.example.museoegipto.ui.screens.ArticleScreen
import com.example.museoegipto.ui.screens.HomeScreen
import com.example.museoegipto.ui.screens.OnboardingScreen
import com.example.museoegipto.ui.screens.Screen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MuseoEgiptoApp()
        }
    }
}

@Composable
fun MuseoEgiptoApp() {
    val vm: AppViewModel = viewModel()
    val navController = rememberNavController()

    var navBundle: Bundle? = remember { null }

    val startDestination = if (vm.isFirstTimeUser) Screen.Onboarding else Screen.Home

    MuseoEgiptoTheme(
        colorScheme = if (vm.isHighContrast) highContrastLightColorScheme else lightScheme,
    ) {
        NavHost(navController = navController, startDestination = startDestination) {

            composable<Screen.Onboarding> {
                OnboardingScreen(
                    onAgeSelected = { ageGroup ->
                        vm.updateAgeGroup(ageGroup)
                        vm.saveFirstTimePreference(false)

                        navController.navigate(Screen.Home) {
                            popUpTo(Screen.Onboarding) { inclusive = true }
                        }
                    }
                )
            }

            composable<Screen.Home> {
                HomeScreen(
                    textScale = vm.textScale,
                    onTextScaleChange = vm::updateTextScale,
                    isHighContrast = vm.isHighContrast,
                    onHighContrastChange = vm::updateIsHighContrast,
                    selectedAgeGroup = vm.selectedAgeGroup,
                    onAgeGroupSelected = vm::updateAgeGroup,
                    onArticleClick = { article ->
                        vm.updateArticle(article)
                        navBundle = navController.saveState()
                        navController.navigate(Screen.Article)
                    }
                )
            }

            composable<Screen.Article>(
                exitTransition = {
                    fadeOut(animationSpec = tween(300))
                }
            ) {
                if (vm.selectedArticle != null) {
                    ArticleScreen(
                        article = vm.selectedArticle!!,
                        textScale = vm.textScale,
                        onBackClick = {
                            navController.navigateUp()
                            navController.restoreState(navBundle)
                        }
                    )
                }
            }
        }
    }
}

class AppViewModel : ViewModel() {
    var textScale by mutableFloatStateOf(1f)
    var isHighContrast by mutableStateOf(false)
    var selectedAgeGroup by mutableStateOf(AgeGroup.ADULT)
    var isFirstTimeUser by mutableStateOf(true)
    var selectedArticle by mutableStateOf<Article?>(null)

    fun updateArticle(article: Article) {
        selectedArticle = article
    }

    fun updateTextScale(newTextScale: Float) {
        textScale = newTextScale
    }

    fun updateIsHighContrast(newHighContrast: Boolean) {
        isHighContrast = newHighContrast
    }

    fun updateAgeGroup(ageGroup: AgeGroup) {
        selectedAgeGroup = ageGroup
    }

    fun saveFirstTimePreference(isFirstTime: Boolean) {
        isFirstTimeUser = isFirstTime
    }
}