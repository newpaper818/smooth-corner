package com.newpaper.smooth_corner

import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection

class AbsoluteSmoothRoundedCornerShape(
    topLeft: CornerSize,
    topRight: CornerSize,
    bottomRight: CornerSize,
    bottomLeft: CornerSize,
    val smoothing: Float = DefaultSmoothing,
) : CornerBasedShape(
    topStart = topLeft,
    topEnd = topRight,
    bottomEnd = bottomRight,
    bottomStart = bottomLeft,
) {
    constructor(
        topLeft: Dp,
        topRight: Dp,
        bottomRight: Dp,
        bottomLeft: Dp,
        smoothing: Float = DefaultSmoothing,
    ) : this(
        topLeft = CornerSize(topLeft),
        topRight = CornerSize(topRight),
        bottomRight = CornerSize(bottomRight),
        bottomLeft = CornerSize(bottomLeft),
        smoothing = smoothing,
    )

    constructor(
        topLeftPercent: Int,
        topRightPercent: Int,
        bottomRightPercent: Int,
        bottomLeftPercent: Int,
        smoothing: Float = DefaultSmoothing,
    ) : this(
        topLeft = CornerSize(topLeftPercent),
        topRight = CornerSize(topRightPercent),
        bottomRight = CornerSize(bottomRightPercent),
        bottomLeft = CornerSize(bottomLeftPercent),
        smoothing = smoothing,
    )





    override fun copy(
        topStart: CornerSize,
        topEnd: CornerSize,
        bottomEnd: CornerSize,
        bottomStart: CornerSize
    ) = SmoothRoundedCornerShape(
        topStart = topStart,
        topEnd = topEnd,
        bottomEnd = bottomEnd,
        bottomStart = bottomStart,
        smoothing = smoothing,
    )

    override fun createOutline(
        size: Size,
        topStart: Float,
        topEnd: Float,
        bottomEnd: Float,
        bottomStart: Float,
        layoutDirection: LayoutDirection
    ): Outline {
        val path = Path.smoothRoundedRectangle(
            size = size,
            topLeft = topStart,
            topRight = topEnd,
            bottomRight = bottomEnd,
            bottomLeft = bottomStart,
            smoothing = smoothing,
        )
        return Outline.Generic(path)
    }
}
