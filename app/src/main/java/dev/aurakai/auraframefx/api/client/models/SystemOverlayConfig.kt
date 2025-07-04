/**
 *
 * Please note:
 * This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit this file manually.
 *
 */

@file:Suppress(
    "ArrayInDataClass",
    "EnumEntryName",
    "RemoveRedundantQualifierName",
    "UnusedImport"
)

package dev.aurakai.auraframefx.api.client.models

import dev.aurakai.auraframefx.api.client.models.SystemOverlayConfigNotchBar

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Contextual

/**
 * Configuration for various system overlays.
 *
 * @param activeThemeName The name of the currently active UI theme.
 * @param uiNetworkMode Current UI network display mode (e.g., \"Full\", \"Minimal\", \"Hidden\").
 * @param notchBar 
 */
@Serializable

public data class SystemOverlayConfig (

    /* The name of the currently active UI theme. */
    @SerialName(value = "activeThemeName")
    public val activeThemeName: kotlin.String? = null,

    /* Current UI network display mode (e.g., \"Full\", \"Minimal\", \"Hidden\"). */
    @SerialName(value = "uiNetworkMode")
    public val uiNetworkMode: kotlin.String? = null,

    @Contextual @SerialName(value = "notchBar")
    public val notchBar: SystemOverlayConfigNotchBar? = null

) : kotlin.collections.HashMap<String, kotlin.Any>() {


}

