package dev.aurakai.auraframefx.generated.model

import kotlinx.serialization.Serializable

/**
 * User model generated from OpenAPI spec
 */
@Serializable
public data class User(
    public val id: String,
    public val username: String,
    public val email: String,
    public val preferences: UserPreferences? = null
)

@Serializable
public data class UserPreferences(
    public val themeId: String? = null,
    public val language: String? = null,
    public val notificationsEnabled: Boolean? = null
)

@Serializable
public data class UserPreferencesUpdate(
    public val preferences: UserPreferences
)
