package dev.aurakai.auraframefx.generated.model

import kotlinx.serialization.Serializable

/**
 * Conference Room models generated from OpenAPI spec
 */
@Serializable
public data class ConferenceRoomCreateRequest(
    public val roomName: String,
    public val orchestratorAgent: AgentType
)

@Serializable
public data class ConferenceRoom(
    public val id: String,
    public val name: String,
    public val orchestrator: AgentType,
    public val activeAgents: List<AgentType>
)
