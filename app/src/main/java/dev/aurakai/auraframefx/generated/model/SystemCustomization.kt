package dev.aurakai.auraframefx.generated.model

import kotlinx.serialization.Serializable

/**
 * System customization models generated from OpenAPI spec
 */
@Serializable
public data class LockScreenConfig(
    public val clockConfig: ClockConfig? = null,
    public val animation: AnimationConfig? = null,
    public val hapticFeedback: HapticFeedbackConfig? = null
)

@Serializable
public data class ClockConfig(
    public val customTextColorEnabled: Boolean = false,
    public val customTextColor: String? = null,
    public val customTextSizeEnabled: Boolean = false,
    public val customTextSize: Float? = null
)

@Serializable
public data class AnimationConfig(
    public val enabled: Boolean = true,
    public val type: AnimationType = AnimationType.Fade
)

@Serializable
public enum class AnimationType {
    Fade, Slide, Zoom
}

@Serializable
public data class HapticFeedbackConfig(
    public val enabled: Boolean = true,
    public val intensity: Int = 150
)
