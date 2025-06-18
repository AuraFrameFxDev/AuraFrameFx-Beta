package dev.aurakai.auraframefx.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.aurakai.auraframefx.ai.agents.GenesisAgent
import dev.aurakai.auraframefx.ai.task.HistoricalTask
import dev.aurakai.auraframefx.model.AgentConfig
import dev.aurakai.auraframefx.model.AgentType
import dev.aurakai.auraframefx.utils.AppConstants.STATUS_ERROR
import dev.aurakai.auraframefx.utils.AppConstants.STATUS_IDLE
import dev.aurakai.auraframefx.utils.AppConstants.STATUS_PROCESSING
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
// import javax.inject.Singleton // ViewModels should use @HiltViewModel

// @Singleton // Replaced with @HiltViewModel (implicitly, if this were a Hilt ViewModel)
public class GenesisAgentViewModel @Inject constructor(
    private val genesisAgent: GenesisAgent,
) : ViewModel() {

    private val _agents = MutableStateFlow<List<AgentConfig>>(emptyList()) // Initialize properly
    val agents: StateFlow<List<AgentConfig>> = _agents.asStateFlow()

    // Track agent status
    private val _agentStatus = MutableStateFlow<Map<AgentType, String>>(
        AgentType.values().associateWith { STATUS_IDLE }
    )
    val agentStatus: StateFlow<Map<AgentType, String>> = _agentStatus.asStateFlow()

    // Track task history
    private val _taskHistory = MutableStateFlow<List<HistoricalTask>>(emptyList())
    val taskHistory: StateFlow<List<HistoricalTask>> = _taskHistory.asStateFlow()

    // Track rotation state
    private val _isRotating = MutableStateFlow(true)
    val isRotating: StateFlow<Boolean> = _isRotating.asStateFlow()

    init { // Initialize agents in init block
        _agents.value = genesisAgent.getAgentsByPriority()
    }

    public fun toggleRotation() {
        _isRotating.value = !_isRotating.value
    }

    public fun toggleAgent(agent: AgentType) {
        viewModelScope.launch {
            genesisAgent.toggleAgent(agent)
        }
    }

    public fun updateAgentStatus(agent: AgentType, status: String) {
        val currentStatuses = _agentStatus.value.toMutableMap()
        currentStatuses[agent] = status
        _agentStatus.value = currentStatuses
    }

    public fun assignTaskToAgent(agent: AgentType, taskDescription: String) {
        viewModelScope.launch {
            try {
                // Update status to processing
                updateAgentStatus(agent, STATUS_PROCESSING)

                // Add to task history
                addTaskToHistory(agent, taskDescription)

                // Simulate processing delay
                delay(5000)

                // Update status back to idle after processing
                updateAgentStatus(agent, STATUS_IDLE)
            } catch (e: Exception) {
                updateAgentStatus(agent, STATUS_ERROR)
                addTaskToHistory(agent, "Error: ${e.message}")
            }
        }
    }

    public fun addTaskToHistory(agent: AgentType, description: String) {
        val newTask = HistoricalTask(agent, description)
        val updatedHistory = _taskHistory.value.toMutableList()
        updatedHistory.add(0, newTask) // Add to the beginning for most recent first
        _taskHistory.value = updatedHistory
    }

    public fun clearTaskHistory() {
        _taskHistory.value = emptyList()
    }

    public fun registerAuxiliaryAgent(
        name: String,
        capabilities: Set<String>,
    ): AgentConfig {
        return genesisAgent.registerAuxiliaryAgent(name, capabilities)
    }

    public fun getAgentConfig(name: String): AgentConfig? {
        return genesisAgent.getAgentConfig(name)
    }

    public fun getAgentsByPriority(): List<AgentConfig> {
        return genesisAgent.getAgentsByPriority()
    }

    public fun processQuery(query: String): List<AgentConfig> {
        viewModelScope.launch {
            genesisAgent.processQuery(query)
        }
        return emptyList() // Return empty list since processing is async
    }
}
