package com.newpaper.smooth_corner

import androidx.compose.ui.graphics.asComposePath
import androidx.graphics.shapes.RoundedPolygon
import androidx.graphics.shapes.toPath

actual fun RoundedPolygon.toComposePath() = toPath().asComposePath()