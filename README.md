# 🌀 Smooth Corner for Jetpack Compose (Multiplatform)

A **Jetpack Compose Multiplatform** library that provides **smooth rounded corner shapes** — perfect for iOS-like or Figma’s "Smooth corner" designs.  
Built using [`androidx.graphics.shapes.RoundedPolygon`](https://developer.android.com/reference/androidx/graphics/shapes/RoundedPolygon).

Supports:
- **Android**
- **iOS (Arm64 / X64 / Simulator)**
- **Desktop (JVM)**

</br>
</br>

## 🧩 Installation


Add it in your `settings.gradle.kts` at the end of repositories:

```kotlin
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
    }
}
```

Add the dependency:
```kotlin
dependencies {
    implementation("com.github.newpaper818.smooth-corner:smooth-corner:0.9.5")
}
```

</br>
</br>

## 🧱 Usage

### Examples
```kotlin
// SmoothRoundedCornerShape
SmoothRoundedCornerShape(radius = 16.dp) //smoothing = 0.6f is default
SmoothRoundedCornerShape(radius = 16.dp, smoothing = 0.6f)
SmoothRoundedCornerShape(percent = 25, smoothing = 0.6f)
SmoothRoundedCornerShape(topStart = 16.dp, topEnd = 5.dp, bottomEnd = 0.dp, bottomStart = 20.dp, smoothing = 0.6f)
SmoothRoundedCornerShape(topStartPercent = 10, topEndPercent = 5, bottomEndPercent = 0, bottomStartPercent = 20, smoothing = 0.6f)

// AbsoluteSmoothRoundedCornerShape
AbsoluteSmoothRoundedCornerShape(topLeft = 10.dp, topRight = 5.dp, bottomRight = 0.dp, bottomLeft = 20.dp, smoothing = 0.6f)
AbsoluteSmoothRoundedCornerShape(topLeftPercent = 10, topRightPercent = 5, bottomRightPercent = 0, bottomLeftPercent = 20, smoothing = 0.6f)

// Path.smoothRoundedRectangle
Path.smoothRoundedRectangle(size = Size(100f, 50f), topLeft = 10f, topRight = 5f, bottomRight = 0f, bottomLeft = 20f, smoothing = 0.6f)
```

### Basic Example
```kotlin
@Composable
fun SmoothCornerSample() {
    Box(
        modifier = Modifier
            .size(120.dp)
            .clip(SmoothRoundedCornerShape(16.dp))
    ) {}
}
```

### Different corner size
```kotlin
@Composable
fun SmoothCornerSample() {
    Box(
        modifier = Modifier
            .size(120.dp)
            .clip(SmoothRoundedCornerShape(
                topStart = 40.dp,
                topEnd = 10.dp,
                bottomEnd = 24.dp,
                bottomStart = 16.dp,
                smoothing = 0.6f // same as iOS-style
              )
            )
    ) {}
}
```

### Absolute shape (no layout direction mirroring)
```kotlin
@Composable
fun SmoothCornerSample() {
    Box(
        modifier = Modifier
            .size(120.dp)
            .clip(AbsoluteSmoothRoundedCornerShape(
                topLeft = 24.dp,
                topRight = 48.dp,
                bottomRight = 12.dp,
                bottomLeft = 36.dp,
                smoothing = 0.8f
              )
            )
    ) {}
}
```


