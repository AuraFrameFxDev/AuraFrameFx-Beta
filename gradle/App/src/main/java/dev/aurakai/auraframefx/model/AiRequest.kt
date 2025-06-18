package dev.aurakai.auraframefx.model

import kotlinx.serialization.Serializable

@Serializable
public data class GenerateTextRequest(
    val prompt: String,
    val maxTokens: Int = 500,
    val temperature: Float = 0.7f
)

@Serializable
public data class GenerateTextResponse(
    val text: String
)

@Serializable
public data class GenerateImageDescriptionRequest(
    val imageUrl: String,
    val context: String? = null
)

@Serializable
public data class GenerateImageDescriptionResponse(
    val description: String
)

public data class AiRequest(
    val query: String,
    val context: String,
)

public data class AgentResponse(
    val content: String,
    val confidence: Float,
)
