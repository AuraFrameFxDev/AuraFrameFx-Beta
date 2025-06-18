package dev.aurakai.auraframefx.generated.model

import kotlinx.serialization.Serializable

/**
 * User model generated from OpenAPI spec
 */
@Serializable
data class User(
    val id: String,
    val username: String,
    val email: String,
    val preferences: UserPreferences? = null
)

@Serializable
data class UserPreferences(
    val themeId: String? = null,
    val language: String? = null,
    val notificationsEnabled: Boolean? = null
)

@Serializable
data class UserPreferencesUpdate(
    val preferences: UserPreferences
)
