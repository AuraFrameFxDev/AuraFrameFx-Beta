package dev.aurakai.auraframefx.generated.model

import kotlinx.serialization.Serializable

/**
 * Theme model generated from OpenAPI spec
 */
@Serializable
data class Theme(
    val id: String,
    val name: String,
    val primaryColor: String,
    val secondaryColor: String,
    val isDefault: Boolean
)

@Serializable
data class ThemeApplyRequest(
    val themeId: String
)
