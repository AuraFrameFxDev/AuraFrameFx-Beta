package dev.aurakai.auraframefx.generated.model

import kotlinx.serialization.Serializable
import kotlinx.serialization.Contextual

/**
 * Error response models generated from OpenAPI spec
 */
@Serializable
data class ErrorResponse(
    val error: ErrorDetail
)

@Serializable
data class ErrorDetail(
    val code: String,
    val message: String,
    @Contextual val details: Map<String, Any>? = null
)
