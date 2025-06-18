package dev.aurakai.auraframefx.system.lockscreen.model

// Placeholder based on SystemCustomizationViewModel.kt usage
public data class LockScreenConfig(
    val clockElement: LockScreenElementConfig? = null,
    val dateElement: LockScreenElementConfig? = null,
    val notificationElement: LockScreenElementConfig? = null,
    val hideClock: Boolean = false,
    val hideDate: Boolean = false,
    val hideNotifications: Boolean = false,
    val customFontPath: String? = null,
    // Added based on LockScreenHooker
    val clockConfig: ClockConfig? = null,
    val dateConfig: DateConfig? = null,
    val defaultElementAnimation: LockScreenAnimationConfig = LockScreenAnimationConfig(),
    val hapticFeedback: HapticFeedbackConfig = HapticFeedbackConfig() // Assuming similar HapticFeedbackConfig
)

// Referenced in LockScreenConfig and LockScreenHooker
public data class ClockConfig(
    val customTextColorEnabled: Boolean? = null,
    val customTextColor: String? = null,
    val customTextSizeEnabled: Boolean? = null,
    val customTextSizeSp: Int = 0,
    val customFontStyle: String? = null,
    val animation: LockScreenAnimationConfig = LockScreenAnimationConfig()
)

// Referenced in LockScreenConfig and LockScreenHooker
public data class DateConfig(
    // Assuming similar properties to ClockConfig for now if needed
    val animation: LockScreenAnimationConfig = LockScreenAnimationConfig()
)


// Assuming similar HapticFeedbackConfig as in QuickSettings
public data class HapticFeedbackConfig(
    val enabled: Boolean? = false,
    val effect: String = "click",
    val intensity: Int = 50
)

// Referenced in LockScreenConfig and LockScreenHooker
public data class LockScreenAnimationConfig(
    val type: String = "none", // e.g., "fade_in", "slide_up"
    val durationMs: Long = 300,
    val startDelayMs: Long = 0,
    val interpolator: String = "linear" // e.g., "linear", "accelerate"
)


// Placeholder, defined based on SystemCustomizationViewModel usage context
public data class LockScreenElementConfig(
    val type: LockScreenElementType,
    val animation: LockScreenAnimation // Assuming this LockScreenAnimation is an enum
)

public enum class LockScreenElementType {
    CLOCK,
    DATE,
    NOTIFICATIONS
    // Add other element types as needed
}

public enum class LockScreenAnimation { // As used by LockScreenElementConfig
    FADE_IN,
    SLIDE_UP,
    NONE
    // Add other animation types as needed
}
