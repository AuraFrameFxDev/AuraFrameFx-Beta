package dev.aurakai.auraframefx.model

/**
 * Represents different types of user or system activities.
 * TODO: Reported as unused symbol. Ensure this sealed class is used.
 */
public sealed class ActivityType {
    /**
     * User is typing.
     * TODO: Reported as unused symbol.
     */
    public object Typing : ActivityType()

    /**
     * User is scrolling.
     * TODO: Reported as unused symbol.
     */
    public object Scrolling : ActivityType()

    /**
     * User is clicking.
     * TODO: Reported as unused symbol.
     */
    public object Clicking : ActivityType()

    /**
     * User is providing voice input.
     * TODO: Reported as unused symbol.
     */
    public object VoiceInput : ActivityType()

    // You can add data class variants if they need to carry specific data
    // data class CustomActivity(val name: String, val details: Map<String, Any>) : ActivityType()
}
