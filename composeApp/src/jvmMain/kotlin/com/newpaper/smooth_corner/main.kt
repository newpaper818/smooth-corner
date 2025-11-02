package com.newpaper.smooth_corner

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Smoothcorner",
    ) {
        App()
    }
}