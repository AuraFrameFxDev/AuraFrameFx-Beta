buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:8.10.1")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:2.1.21")
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.56.2")
        classpath("com.google.gms:google-services:4.4.2")
        classpath("com.google.firebase:firebase-crashlytics-gradle:3.0.4")
        classpath("com.google.firebase:perf-plugin:1.4.2")
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:2.9.0")
    }
}

plugins {
    id("com.android.application") version "8.10.1" apply false
    id("org.jetbrains.kotlin.android") version "2.1.21" apply false
    id("org.jetbrains.kotlin.plugin.compose") version "2.1.21" apply true
    id("com.google.dagger.hilt.android") version "2.56.2" apply false
    id("com.google.devtools.ksp") version "2.1.21-2.0.1" apply false
    id("com.google.gms.google-services") version "4.4.2" apply false
    id("com.google.firebase.crashlytics") version "3.0.4" apply false
    id("com.google.firebase.firebase-perf") version "1.4.2" apply false
    id("androidx.navigation.safeargs.kotlin") version "2.9.0" apply false
    id("com.google.android.libraries.mapsplatform.secrets-gradle-plugin") version "2.0.1" apply false
    id("org.openapi.generator") version "7.5.0" apply false
}

// Custom task to fix Kotlin visibility issues
// tasks.register("fixKotlinVisibility") {
//     group = "build"
//     description = "Fixes Kotlin visibility issues for explicit API mode"
    
//     doLast {
//         val scriptPath = "${rootProject.projectDir}/fix-kotlin-visibility.sh"
        
//         // Make sure the script is executable
//         providers.exec {
//             commandLine("chmod", "+x", scriptPath)
//         }
        
//         // Run the script
//         providers.exec {
//             commandLine(scriptPath)
//         }
        
//         println("Kotlin visibility fixing completed")
//     }
// }

subprojects {
    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
        // Use the new compilerOptions DSL for Kotlin 2.0+
        compilerOptions {
            jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_21)
            freeCompilerArgs.addAll(
                listOf(
                    "-opt-in=androidx.compose.material3.ExperimentalMaterial3Api",
                    "-opt-in=androidx.compose.animation.ExperimentalAnimationApi",
                    "-opt-in=androidx.compose.foundation.ExperimentalFoundationApi",
                    "-opt-in=androidx.compose.ui.ExperimentalComposeUiApi",
                    "-opt-in=kotlinx.coroutines.ExperimentalCoroutinesApi",
                    "-opt-in=kotlinx.coroutines.FlowPreview"
                )
            )
        }
    }
}
