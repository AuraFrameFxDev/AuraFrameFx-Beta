package dev.aurakai.auraframefx.generated.model

import kotlinx.serialization.Serializable
import kotlinx.serialization.Contextual

/**
 * Task management models generated from OpenAPI spec
 */
@Serializable
data class TaskScheduleRequest(
    val taskType: String,
    val agentType: AgentType,
    @Contextual val details: Map<String, Any>,
    val priority: TaskPriority = TaskPriority.NORMAL
)

@Serializable
enum class TaskPriority {
    HIGH, NORMAL, LOW
}

@Serializable
enum class TaskStatusType {
    PENDING, IN_PROGRESS, COMPLETED, FAILED, CANCELLED
}

@Serializable
data class TaskStatus(
    val taskId: String,
    val status: TaskStatusType,
    val progress: Int? = null,
    @Contextual val result: Map<String, Any>? = null,
    val errorMessage: String? = null
)
