package dev.aurakai.auraframefx.generated.model.auraframefxai

import kotlinx.serialization.Serializable

/**
 * GenerateImageDescriptionResponse model generated from OpenAPI spec
 */
@Serializable
data class GenerateImageDescriptionResponse(
    val description: String,
    val confidence: Float = 1.0f
)
