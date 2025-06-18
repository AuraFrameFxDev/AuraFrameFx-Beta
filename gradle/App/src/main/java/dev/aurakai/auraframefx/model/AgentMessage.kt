package dev.aurakai.auraframefx.model

import kotlinx.serialization.Serializable
import dev.aurakai.auraframefx.model.AgentType // Added import

@Serializable
public data class AgentMessage(
    val content: String,
    val sender: AgentType, // Should now refer to the imported AgentType
    val timestamp: Long,
    val confidence: Float,
)

// Removed local AgentType enum
