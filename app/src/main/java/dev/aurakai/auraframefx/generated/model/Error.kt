package dev.aurakai.auraframefx.generated.model

import kotlinx.serialization.Serializable
import kotlinx.serialization.Contextual

/**
 * Error response models generated from OpenAPI spec
 */
@Serializable
public data class ErrorResponse(
    public val error: ErrorDetail
)

@Serializable
public data class ErrorDetail(
    public val code: String,
    public val message: String,
    @Contextual val details: Map<String, Any>? = null
)
