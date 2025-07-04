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

import dev.aurakai.auraframefx.api.client.models.AgentType

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Contextual

/**
 * 
 *
 * @param agentType The AI agent leaving the room.
 */
@Serializable

public data class ConferenceRoomLeaveRequest (

    /* The AI agent leaving the room. */
    @Contextual @SerialName(value = "agentType")
    public val agentType: AgentType

) {


}

