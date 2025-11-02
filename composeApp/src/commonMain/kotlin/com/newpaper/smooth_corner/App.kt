package com.newpaper.smooth_corner

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.displayCutoutPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {

        val scale = 2f
        val padding = 4.dp * scale
        val boxWidth = 100.dp * scale
        val boxHeight = 60.dp * scale
        val radius = 16.dp * scale
        val boxColor = Color.DarkGray


        Column(
            modifier = Modifier
                .fillMaxSize()
                .displayCutoutPadding()
                .navigationBarsPadding()
                .background(Color.White)
        ) {

            Box(
                modifier = Modifier
                    .padding(padding)
                    .size(boxWidth, boxHeight)
                    .clip(SmoothRoundedCornerShape(radius, 0.1f))
                    .background(boxColor)
            )

            Box(
                modifier = Modifier
                    .padding(padding)
                    .size(boxWidth, boxHeight)
                    .clip(SmoothRoundedCornerShape(radius, 0.6f))
                    .background(boxColor)
            )

            Box(
                modifier = Modifier
                    .padding(padding)
                    .size(boxWidth, boxHeight)
                    .clip(SmoothRoundedCornerShape(radius, 0.9f))
                    .background(boxColor)
            )
            

            Box(
                modifier = Modifier
                    .padding(padding)
                    .size(boxWidth, boxHeight)
                    .clip(RoundedCornerShape(radius))
                    .background(boxColor)
            )
        }
    }
}