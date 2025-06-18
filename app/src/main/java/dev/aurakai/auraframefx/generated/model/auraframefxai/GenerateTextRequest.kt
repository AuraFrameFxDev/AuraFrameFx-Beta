package dev.aurakai.auraframefx.generated.model.auraframefxai

import kotlinx.serialization.Serializable

/**
 * GenerateTextRequest model generated from OpenAPI spec
 */
@Serializable
public data class GenerateTextRequest(
    public val prompt: String,
    public val maxTokens: Int = 500,
    public val temperature: Float = 0.7f
)
