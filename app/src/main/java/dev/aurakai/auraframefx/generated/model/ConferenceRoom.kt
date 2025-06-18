package dev.aurakai.auraframefx.generated.model

import kotlinx.serialization.Serializable

/**
 * Conference Room models generated from OpenAPI spec
 */
@Serializable
data class ConferenceRoomCreateRequest(
    val roomName: String,
    val orchestratorAgent: AgentType
)

@Serializable
data class ConferenceRoom(
    val id: String,
    val name: String,
    val orchestrator: AgentType,
    val activeAgents: List<AgentType>
)
