package dev.aurakai.auraframefx.data

public class AppStateManager {
    // Minimal placeholder implementation
    var state: String = "default"

    public fun updateState(newState: String) {
        state = newState
    }

    public fun getState(): String = state
}
