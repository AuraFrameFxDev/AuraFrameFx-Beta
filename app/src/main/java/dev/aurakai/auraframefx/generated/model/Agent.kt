package dev.aurakai.auraframefx.generated.model

import kotlinx.serialization.Serializable
import kotlinx.serialization.Contextual

/**
 * AI Agent types and models generated from OpenAPI spec
 */
@Serializable
public enum class AgentType {
    Aura, Kai, Genesis, Cascade, NeuralWhisper, AuraShield, GenKitMaster
}

@Serializable
public data class AgentProcessRequest(
    public val prompt: String,
    @Contextual val context: Map<String, Any>? = null
)

@Serializable
public data class AgentMessage(
    public val sender: AgentType,
    public val message: String,
    public val timestamp: String
)
