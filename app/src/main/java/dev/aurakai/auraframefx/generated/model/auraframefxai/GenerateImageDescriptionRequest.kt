package dev.aurakai.auraframefx.generated.model.auraframefxai

import kotlinx.serialization.Serializable

@Serializable
data class GenerateImageDescriptionRequest(
    val imageData: String, // Base64 encoded image
    val prompt: String = "Describe this image",
    val maxTokens: Int = 500,
    val model: String = "gemini-pro-vision"
)
