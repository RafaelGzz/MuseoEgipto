package com.example.museoegipto.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Slider
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose.MuseoEgiptoTheme
import com.example.museoegipto.model.AgeGroup

@Composable
fun SettingsDialog(
    textScale: Float = 1f,
    onTextScaleChange: (Float) -> Unit = {},
    isHighContrast: Boolean = false,
    onHighContrastChange: (Boolean) -> Unit = {},
    selectedAgeGroup: AgeGroup = AgeGroup.ADULT,
    onAgeGroupSelected: (AgeGroup) -> Unit = {},
    onDismiss: () -> Unit = {}
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Text(
                "Configuración",
                style = MaterialTheme.typography.titleLarge.copy(
                    fontSize = MaterialTheme.typography.titleLarge.fontSize * textScale,
                ),
            )
        },
        text = {
            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .padding(vertical = 8.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // Sección de Grupo de Edad
                Text(
                    "Grupo de Edad",
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontSize = MaterialTheme.typography.titleMedium.fontSize * textScale,
                    ),
                )
                Column(
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    AgeGroup.entries.forEach { ageGroup ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable { onAgeGroupSelected(ageGroup) },
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            RadioButton(
                                selected = selectedAgeGroup == ageGroup,
                                onClick = { onAgeGroupSelected(ageGroup) }
                            )
                            Text(
                                text = when (ageGroup) {
                                    AgeGroup.CHILDREN -> "Niños"
                                    AgeGroup.TEEN -> "Adolescentes"
                                    AgeGroup.ADULT -> "Adultos"
                                },
                                style = MaterialTheme.typography.bodyMedium.copy(
                                    fontSize = MaterialTheme.typography.bodyMedium.fontSize * textScale,
                                ),
                                modifier = Modifier.padding(start = 8.dp)
                            )
                        }
                    }
                }

                HorizontalDivider()

                // Sección de Accesibilidad
                Text(
                    "Accesibilidad",
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontSize = MaterialTheme.typography.titleMedium.fontSize * textScale,
                    ),
                )

                // Control de tamaño de texto
                Column {
                    Text(
                        "Tamaño del texto",
                        style = MaterialTheme.typography.bodyMedium.copy(
                            fontSize = MaterialTheme.typography.bodyMedium.fontSize * textScale,
                        ),
                    )
                    Slider(
                        value = textScale,
                        onValueChange = onTextScaleChange,
                        valueRange = 1f..2.0f,
                        steps = 5
                    )
                }

                // Modo de alto contraste
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        "Alto contraste",
                        style = MaterialTheme.typography.bodyMedium.copy(
                            fontSize = MaterialTheme.typography.bodyMedium.fontSize * textScale,
                        ),
                    )
                    Switch(
                        checked = isHighContrast,
                        onCheckedChange = onHighContrastChange
                    )
                }
            }
        },
        confirmButton = {
            TextButton(onClick = onDismiss) {
                Text(
                    "Cerrar",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontSize = MaterialTheme.typography.bodyMedium.fontSize * textScale,
                    ),
                )
            }
        }
    )
}

@Preview
@Composable
private fun SettingsDialogPreview() {
    MuseoEgiptoTheme {
        SettingsDialog()
    }
}