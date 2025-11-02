package com.newpaper.smooth_corner

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform