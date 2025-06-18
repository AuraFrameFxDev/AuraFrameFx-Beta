package dev.aurakai.auraframefx.generated.model

import kotlinx.serialization.Serializable
import kotlinx.serialization.Contextual

/**
 * AI Agent types and models generated from OpenAPI spec
 */
@Serializable
enum class AgentType {
    Aura, Kai, Genesis, Cascade, NeuralWhisper, AuraShield, GenKitMaster
}

@Serializable
data class AgentProcessRequest(
    val prompt: String,
    @Contextual val context: Map<String, Any>? = null
)

@Serializable
data class AgentMessage(
    val sender: AgentType,
    val message: String,
    val timestamp: String
)
