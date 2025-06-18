package dev.aurakai.auraframefx.generated.model.auraframefxai

import kotlinx.serialization.Serializable

/**
 * GenerateTextRequest model generated from OpenAPI spec
 */
@Serializable
data class GenerateTextRequest(
    val prompt: String,
    val maxTokens: Int = 500,
    val temperature: Float = 0.7f
)
