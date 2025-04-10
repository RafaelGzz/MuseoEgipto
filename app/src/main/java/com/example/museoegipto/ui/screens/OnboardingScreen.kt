package com.example.museoegipto.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.museoegipto.R
import com.example.museoegipto.model.AgeGroup
import com.example.museoegipto.ui.theme.LordStoryFontFamily

@Composable
fun OnboardingScreen(
    onAgeSelected: (AgeGroup) -> Unit,
    modifier: Modifier = Modifier
) {
    var selectedAgeGroup by remember { mutableStateOf<AgeGroup?>(null) }

    Box(
        modifier = modifier.fillMaxSize()
    ) {
        // Fondo con imagen de jeroglificos
        Image(
            painter = painterResource(R.drawable.fondo),
            contentScale = ContentScale.Crop,
            contentDescription = "Fondo de pantalla de jeroglificos",
            modifier = Modifier.fillMaxSize()
        )

        // Capa oscura para mejorar la legibilidad
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.6f))
        )

        // Contenido de la pantalla
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Título de bienvenida
            Text(
                text = "Museo Egipcio",
                style = MaterialTheme.typography.headlineLarge, fontFamily = LordStoryFontFamily,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(32.dp))

            // Subtítulo
            Text(
                text = "¡Bienvenido! Selecciona tu rango de edad para personalizar tu experiencia",
                style = MaterialTheme.typography.bodyLarge,
                color = Color.White,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(48.dp))

            // Opciones de edad
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surface.copy(alpha = 0.9f)
                )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    AgeGroupOption(
                        title = "Niños",
                        description = "Contenido adaptado para los más pequeños",
                        ageGroup = AgeGroup.CHILDREN,
                        isSelected = selectedAgeGroup == AgeGroup.CHILDREN,
                        onSelect = { selectedAgeGroup = AgeGroup.CHILDREN },
                        icon = {
                            Image(
                                painter = painterResource(R.drawable.child),
                                contentDescription = "Icono de niño",
                                modifier = Modifier
                                    .size(56.dp)
                                    .clip(CircleShape)
                            )
                        }
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    AgeGroupOption(
                        title = "Adolescentes",
                        description = "Información interesante para jóvenes curiosos",
                        ageGroup = AgeGroup.TEEN,
                        isSelected = selectedAgeGroup == AgeGroup.TEEN,
                        onSelect = { selectedAgeGroup = AgeGroup.TEEN },
                        icon = {
                            Image(
                                painter = painterResource(R.drawable.teen),
                                contentDescription = "Icono de adolescente",
                                modifier = Modifier
                                    .size(56.dp)
                                    .clip(CircleShape)
                            )
                        }
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    AgeGroupOption(
                        title = "Adultos",
                        description = "Contenido completo y detallado",
                        ageGroup = AgeGroup.ADULT,
                        isSelected = selectedAgeGroup == AgeGroup.ADULT,
                        onSelect = { selectedAgeGroup = AgeGroup.ADULT },
                        icon = {
                            Image(
                                painter = painterResource(R.drawable.adult),
                                contentDescription = "Icono de adulto",
                                modifier = Modifier
                                    .size(56.dp)
                                    .clip(CircleShape)
                            )
                        }
                    )
                }
            }

            Spacer(modifier = Modifier.height(32.dp))

            Button(
                onClick = {
                    selectedAgeGroup?.let { onAgeSelected(it) }
                },
                enabled = selectedAgeGroup != null,
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    contentColor = MaterialTheme.colorScheme.onSecondaryContainer
                ),
                modifier = Modifier.fillMaxWidth(0.8f)
            ) {
                Text(
                    text = "Comenzar",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
    }
}

@Composable
private fun AgeGroupOption(
    title: String,
    description: String,
    ageGroup: AgeGroup,
    isSelected: Boolean,
    icon: @Composable () -> Unit = {},
    onSelect: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clip(RoundedCornerShape(8.dp))
            .clickable(onClickLabel = "Seleccionar") { onSelect() }
            .background(
                if (isSelected) Color.Black.copy(alpha = 0.1f)
                else Color.Transparent
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Aquí se colocará un IconButton personalizado en el futuro
        // Por ahora, usamos un círculo coloreado como placeholder
        icon()

        Column(
            modifier = Modifier
                .padding(start = 16.dp)
                .weight(1f)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium, fontFamily = LordStoryFontFamily,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = description,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
} 