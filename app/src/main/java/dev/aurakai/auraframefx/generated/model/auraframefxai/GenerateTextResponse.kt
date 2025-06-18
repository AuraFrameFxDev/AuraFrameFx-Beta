package dev.aurakai.auraframefx.generated.model.auraframefxai

import kotlinx.serialization.Serializable

/**
 * GenerateTextResponse model generated from OpenAPI spec
 */
@Serializable
data class GenerateTextResponse(
    val generatedText: String,
    val finishReason: String
)
