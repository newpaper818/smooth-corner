import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidKotlinMultiplatformLibrary)

    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)

    alias(libs.plugins.mavenPublish)
}

//group = "io.github.newpaper"
//version = "0.9.0"

kotlin {

    androidLibrary {
        namespace = "io.github.newpaper.smooth-corner"
        compileSdk = libs.versions.android.compileSdk.get().toInt()
        minSdk = libs.versions.android.minSdk.get().toInt()

        withJava() // enable java compilation support
        withHostTestBuilder {}.configure {}

        withDeviceTestBuilder {
            sourceSetTreeName = "test"
        }

        compilations.configureEach {
            compilerOptions.configure {
                jvmTarget.set(
                    JvmTarget.JVM_11
                )
            }
        }
    }

    jvm()
    js {
        browser()
        binaries.executable()
    }
    iosX64()
    iosArm64()
    iosSimulatorArm64()
//    linuxX64()


    sourceSets {
        commonMain {
            dependencies {
                implementation(libs.graphics.shapes)
                implementation(compose.foundation)
            }
        }

        commonTest {
            dependencies {
                implementation(libs.kotlin.test)
            }
        }
    }

}

afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("release") {
                from(components["kotlin"])
                groupId = "com.github.newpaper"
                artifactId = "smooth-corner"
                version = "0.9.2"
            }
        }
    }
}