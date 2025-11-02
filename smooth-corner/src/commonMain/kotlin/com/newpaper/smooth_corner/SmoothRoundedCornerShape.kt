package com.newpaper.smooth_corner

import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection

/** Matches the "iOS" notch (60%) in Figma */
const val DefaultSmoothing = 0.6f

class SmoothRoundedCornerShape(
    topStart: CornerSize,
    topEnd: CornerSize,
    bottomEnd: CornerSize,
    bottomStart: CornerSize,
    val smoothing: Float = DefaultSmoothing,
) : CornerBasedShape(
    topStart = topStart,
    topEnd = topEnd,
    bottomEnd = bottomEnd,
    bottomStart = bottomStart,
) {
    constructor(
        radius: Dp,
        smoothing: Float = DefaultSmoothing,
    ) : this(
        CornerSize(radius), smoothing
    )

    constructor(
        percent: Int,
        smoothing: Float = DefaultSmoothing,
    ) : this(
        CornerSize(percent), smoothing
    )

    constructor(
        corner: CornerSize,
        smoothing: Float = DefaultSmoothing,
    ) : this(
        topStart = corner,
        topEnd = corner,
        bottomEnd = corner,
        bottomStart = corner,
        smoothing = smoothing,
    )

    constructor(
        topStart: Dp,
        topEnd: Dp,
        bottomEnd: Dp,
        bottomStart: Dp,
        smoothing: Float = DefaultSmoothing,
    ) : this(
        topStart = CornerSize(topStart),
        topEnd = CornerSize(topEnd),
        bottomEnd = CornerSize(bottomEnd),
        bottomStart = CornerSize(bottomStart),
        smoothing = smoothing,
    )

    constructor(
        topStartPercent: Int,
        topEndPercent: Int,
        bottomEndPercent: Int,
        bottomStartPercent: Int,
        smoothing: Float = DefaultSmoothing,
    ) : this(
        topStart = CornerSize(topStartPercent),
        topEnd = CornerSize(topEndPercent),
        bottomEnd = CornerSize(bottomEndPercent),
        bottomStart = CornerSize(bottomStartPercent),
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
        val topLeft = if (layoutDirection == LayoutDirection.Ltr) topStart else topEnd
        val topRight = if (layoutDirection == LayoutDirection.Ltr) topEnd else topStart
        val bottomLeft = if (layoutDirection == LayoutDirection.Ltr) bottomStart else bottomEnd
        val bottomRight = if (layoutDirection == LayoutDirection.Ltr) bottomEnd else bottomStart

        val path = Path.smoothRoundedRectangle(
            size = size,
            topLeft = topLeft,
            topRight = topRight,
            bottomRight = bottomRight,
            bottomLeft = bottomLeft,
            smoothing = smoothing,
        )
        return Outline.Generic(path)
    }
}


