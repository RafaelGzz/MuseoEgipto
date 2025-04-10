package com.example.museoegipto.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose.MuseoEgiptoTheme
import com.example.museoegipto.data.DataSource
import com.example.museoegipto.model.AgeGroup
import com.example.museoegipto.model.Article
import com.example.museoegipto.model.Section
import com.example.museoegipto.ui.theme.LordStoryFontFamily


@Composable
fun ArticleCard(
    article: Article,
    onClick: () -> Unit = {},
    textScale: Float = 1f,
) {

    //val bannerImage = article.images.firstOrNull()
    ElevatedCard(
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable(onClickLabel = "Leer el artículo") { onClick() }
    ) {
        Column {
            Text(
                text = article.title,
                style = MaterialTheme.typography.titleLarge.copy(
                    fontSize = MaterialTheme.typography.titleLarge.fontSize * textScale,
                    fontFamily = LordStoryFontFamily
                ),
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
            )

            Text(
                text = article.content.split(".").first() + ".",
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontSize = MaterialTheme.typography.bodyMedium.fontSize * textScale,
                    lineHeight = MaterialTheme.typography.bodyMedium.lineHeight * textScale
                ),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .padding(bottom = 8.dp)
            )

            if(article.images.isNotEmpty()) {
                MediaGallery(
                    images = article.images,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}


@Preview
@Composable
private fun ArticleCardPreview() {
    MuseoEgiptoTheme {
        ArticleCard(
            article = DataSource.getArticlesBySection(Section.DAILY_LIFE, AgeGroup.ADULT).first(),
        )
    }
}