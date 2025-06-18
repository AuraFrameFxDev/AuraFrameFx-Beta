package dev.aurakai.auraframefx.generated.model

import kotlinx.serialization.Serializable

/**
 * Theme model generated from OpenAPI spec
 */
@Serializable
public data class Theme(
    public val id: String,
    public val name: String,
    public val primaryColor: String,
    public val secondaryColor: String,
    public val isDefault: Boolean
)

@Serializable
public data class ThemeApplyRequest(
    public val themeId: String
)
