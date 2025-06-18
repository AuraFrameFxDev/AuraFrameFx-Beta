package dev.aurakai.auraframefx.generated.model.auraframefxai

import kotlinx.serialization.Serializable

/**
 * GenerateTextResponse model generated from OpenAPI spec
 */
@Serializable
public data class GenerateTextResponse(
    public val generatedText: String,
    public val finishReason: String
)
