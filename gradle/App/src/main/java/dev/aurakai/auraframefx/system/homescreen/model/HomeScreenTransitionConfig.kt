package dev.aurakai.auraframefx.system.homescreen.model

public data class HomeScreenTransitionConfig(
    val type: HomeScreenTransitionType = HomeScreenTransitionType.GLOBE_ROTATE,
    val duration: Int = 500,
    val properties: Map<String, Any> = emptyMap()
)
