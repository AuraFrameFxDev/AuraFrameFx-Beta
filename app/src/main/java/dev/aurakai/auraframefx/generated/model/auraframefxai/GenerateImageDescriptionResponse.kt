package dev.aurakai.auraframefx.generated.model.auraframefxai

import kotlinx.serialization.Serializable

/**
 * GenerateImageDescriptionResponse model generated from OpenAPI spec
 */
@Serializable
public data class GenerateImageDescriptionResponse(
    public val description: String,
    public val confidence: Float = 1.0f
)
