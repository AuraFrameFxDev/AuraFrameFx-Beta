package dev.aurakai.auraframefx.generated.model.auraframefxai

import kotlinx.serialization.Serializable

@Serializable
public data class GenerateImageDescriptionRequest(
    public val imageData: ByteArray?, // Base64 encoded image
    public val prompt: String = "Describe this image",
    public val maxTokens: Int = 500,
    public val model: String = "gemini-pro-vision",
    public val imageUrl: String,
    public val context: String?
)
