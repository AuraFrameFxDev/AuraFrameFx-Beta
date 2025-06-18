package dev.aurakai.auraframefx.generated.model

import kotlinx.serialization.Serializable
import kotlinx.serialization.Contextual

/**
 * Task management models generated from OpenAPI spec
 */
@Serializable
public data class TaskScheduleRequest(
    public val taskType: String,
    public val agentType: AgentType,
    @Contextual val details: Map<String, Any>,
    public val priority: TaskPriority = TaskPriority.NORMAL
)

@Serializable
public enum class TaskPriority {
    HIGH, NORMAL, LOW
}

@Serializable
public enum class TaskStatusType {
    PENDING, IN_PROGRESS, COMPLETED, FAILED, CANCELLED
}

@Serializable
public data class TaskStatus(
    public val taskId: String,
    public val status: TaskStatusType,
    public val progress: Int? = null,
    @Contextual val result: Map<String, Any>? = null,
    public val errorMessage: String? = null
)
