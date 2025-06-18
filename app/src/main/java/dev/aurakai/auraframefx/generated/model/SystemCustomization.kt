package dev.aurakai.auraframefx.generated.model

import kotlinx.serialization.Serializable

/**
 * System customization models generated from OpenAPI spec
 */
@Serializable
data class LockScreenConfig(
    val clockConfig: ClockConfig? = null,
    val animation: AnimationConfig? = null,
    val hapticFeedback: HapticFeedbackConfig? = null
)

@Serializable
data class ClockConfig(
    val customTextColorEnabled: Boolean = false,
    val customTextColor: String? = null,
    val customTextSizeEnabled: Boolean = false,
    val customTextSize: Float? = null
)

@Serializable
data class AnimationConfig(
    val enabled: Boolean = true,
    val type: AnimationType = AnimationType.Fade
)

@Serializable
enum class AnimationType {
    Fade, Slide, Zoom
}

@Serializable
data class HapticFeedbackConfig(
    val enabled: Boolean = true,
    val intensity: Int = 150
)
