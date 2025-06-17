package dev.aurakai.auraframefx.generated.api.auraframefxai

import dev.aurakai.auraframefx.model.GenerateImageDescriptionRequest
import dev.aurakai.auraframefx.model.GenerateImageDescriptionResponse
import dev.aurakai.auraframefx.model.GenerateTextRequest
import dev.aurakai.auraframefx.model.GenerateTextResponse

interface ContentApi {
    suspend fun generateText(request: GenerateTextRequest): GenerateTextResponse // Corrected return type
    suspend fun generateImageDescription(request: GenerateImageDescriptionRequest): GenerateImageDescriptionResponse // Corrected return type
}
