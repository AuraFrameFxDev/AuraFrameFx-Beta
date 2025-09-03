/*
Testing library/framework:
- AndroidX Compose UI Test with JUnit4 (createComposeRule). This matches project conventions (see existing tests).
*/

package dev.aurakai.auraframefx.datavein.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.test.assertDoesNotExist
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onAllNodesWithText
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import dev.aurakai.auraframefx.datavein.model.DataVeinNode
import dev.aurakai.auraframefx.datavein.model.NodeCategory
import dev.aurakai.auraframefx.datavein.model.NodeType
import org.junit.Rule
import org.junit.Test

class SphereGridComponentsTest {

    @get:Rule
    val composeRule = createComposeRule()

    // Fixture factory aligned with DataVeinNode properties used by composables.
    private fun nodeOf(
        type: NodeType,
        tag: String = "TAG-001",
        id: String = "ID-123",
        ring: Int = 1,
        level: Int = 2,
        xp: Int = 250,
        isUnlocked: Boolean = true,
        activated: Boolean = false,
        data: String = "",
        connectedPaths: List<String> = emptyList()
    ): DataVeinNode {
        // Named args make this resilient to constructor ordering.
        return DataVeinNode(
            id = id,
            x = 0f,
            y = 0f,
            ring = ring,
            activated = activated,
            level = level,
            data = data,
            tag = tag,
            xp = xp,
            isUnlocked = isUnlocked,
            connectedPaths = connectedPaths,
            type = type
        )
    }

    // Wrappers with test tags for easy selection
    @Composable
    private fun NodeInfoPanelTagged(node: DataVeinNode) {
        NodeInfoPanel(node = node, modifier = Modifier.testTag("NodeInfoPanel"))
    }

    @Composable
    private fun NodeTypeLegendTagged() {
        NodeTypeLegend(modifier = Modifier.testTag("NodeTypeLegend"))
    }

    @Composable
    private fun StatusPanelTagged(
        activeFlows: Int,
        activeNodes: Int,
        totalNodes: Int,
        unlockedNodes: Int
    ) {
        StatusPanel(
            activeFlows = activeFlows,
            activeNodes = activeNodes,
            totalNodes = totalNodes,
            unlockedNodes = unlockedNodes,
            modifier = Modifier.testTag("StatusPanel")
        )
    }

    @Composable
    private fun ProgressionIndicatorTagged(selectedNode: DataVeinNode?) {
        ProgressionIndicator(selectedNode = selectedNode, modifier = Modifier.testTag("ProgressionIndicator"))
    }

    // ---------------- NodeInfoPanel ----------------

    @Test
    fun nodeInfoPanel_displaysHeader_identity_description_and_data_whenPresent() {
        val t = NodeType.values().first()
        val node = nodeOf(type = t, data = "payload")
        composeRule.setContent { NodeInfoPanelTagged(node) }

        composeRule.onNodeWithTag("NodeInfoPanel").assertIsDisplayed()
        composeRule.onNodeWithText(t.displayName).assertIsDisplayed()
        composeRule.onNodeWithText("Tag:").assertIsDisplayed()
        composeRule.onNodeWithText("ID:").assertIsDisplayed()
        composeRule.onNodeWithText("Ring:").assertIsDisplayed()
        composeRule.onNodeWithText("Level:").assertIsDisplayed()
        composeRule.onNodeWithText(t.description).assertIsDisplayed()
        composeRule.onNodeWithText("Data:").assertIsDisplayed()
        composeRule.onNodeWithText("payload").assertIsDisplayed()
    }

    @Test
    fun nodeInfoPanel_locked_showsLockedStatus_andHidesXpSection() {
        val t = NodeType.values().first()
        val node = nodeOf(type = t, isUnlocked = false, activated = false, xp = 0)
        composeRule.setContent { NodeInfoPanelTagged(node) }

        composeRule.onNodeWithText("🔒 Locked - Requires Path Progression").assertIsDisplayed()
        composeRule.onNodeWithText("XP:").assertDoesNotExist()
        composeRule.onNodeWithText("0/1000").assertDoesNotExist()
    }

    @Test
    fun nodeInfoPanel_unlockedDormant_showsDormantStatus_andXpRow() {
        val t = NodeType.values().first()
        val node = nodeOf(type = t, isUnlocked = true, activated = false, xp = 500)
        composeRule.setContent { NodeInfoPanelTagged(node) }

        composeRule.onNodeWithText("💤 Dormant - Click to Activate").assertIsDisplayed()
        composeRule.onNodeWithText("XP:").assertIsDisplayed()
        composeRule.onNodeWithText("500/1000").assertIsDisplayed()
    }

    @Test
    fun nodeInfoPanel_active_showsActiveStatus_andFullXp() {
        val t = NodeType.values().first()
        val node = nodeOf(type = t, isUnlocked = true, activated = true, xp = 1000)
        composeRule.setContent { NodeInfoPanelTagged(node) }

        composeRule.onNodeWithText("⚡ Active - Processing Data Flow").assertIsDisplayed()
        composeRule.onNodeWithText("1000/1000").assertIsDisplayed()
    }

    // ---------------- NodeTypeLegend ----------------

    @Test
    fun nodeTypeLegend_showsCategoryHeaders_withTypesDisplayNames() {
        composeRule.setContent { NodeTypeLegendTagged() }

        composeRule.onNodeWithTag("NodeTypeLegend").assertIsDisplayed()

        NodeCategory.values().forEach { cat ->
            val hasTypes = NodeType.values().any { it.category == cat }
            if (hasTypes) {
                composeRule.onNodeWithText(cat.name).assertIsDisplayed()
            }
        }

        NodeType.values().forEach { type ->
            composeRule.onNodeWithText(type.displayName).assertIsDisplayed()
        }
    }

    // ---------------- StatusPanel ----------------

    @Test
    fun statusPanel_displaysCounts_andCalculatedPercentages() {
        composeRule.setContent {
            StatusPanelTagged(
                activeFlows = 3,
                activeNodes = 5,
                totalNodes = 10,
                unlockedNodes = 7
            )
        }

        composeRule.onNodeWithTag("StatusPanel").assertIsDisplayed()
        composeRule.onNodeWithText("Active Flows:").assertIsDisplayed()
        composeRule.onNodeWithText("Active Nodes:").assertIsDisplayed()
        composeRule.onNodeWithText("Unlocked:").assertIsDisplayed()

        composeRule.onNodeWithText("3").assertIsDisplayed()
        composeRule.onNodeWithText("5/10").assertIsDisplayed()
        composeRule.onNodeWithText("7/10").assertIsDisplayed()

        composeRule.onNodeWithText("Activation").assertIsDisplayed()
        composeRule.onNodeWithText("Progression").assertIsDisplayed()
        composeRule.onNodeWithText("50%").assertIsDisplayed()
        composeRule.onNodeWithText("70%").assertIsDisplayed()
    }

    @Test
    fun statusPanel_handlesZeroTotalNodes_showingZeroPercents() {
        composeRule.setContent {
            StatusPanelTagged(
                activeFlows = 0,
                activeNodes = 0,
                totalNodes = 0,
                unlockedNodes = 0
            )
        }

        composeRule.onAllNodesWithText("0/0").assertCountEquals(2) // Active Nodes and Unlocked
        composeRule.onNodeWithText("0%").assertIsDisplayed()
    }

    // ---------------- ProgressionIndicator ----------------

    @Test
    fun progressionIndicator_hiddenWhenNodeNull() {
        composeRule.setContent { ProgressionIndicatorTagged(selectedNode = null) }
        composeRule.onNodeWithText("🎯 Node Progression").assertDoesNotExist()
    }

    @Test
    fun progressionIndicator_hiddenWhenLocked() {
        val node = nodeOf(type = NodeType.values().first(), isUnlocked = false, xp = 200)
        composeRule.setContent { ProgressionIndicatorTagged(selectedNode = node) }
        composeRule.onNodeWithText("🎯 Node Progression").assertDoesNotExist()
    }

    @Test
    fun progressionIndicator_showsNextXp_andAvailablePaths_whenUnlocked() {
        val node = nodeOf(
            type = NodeType.values().first(),
            isUnlocked = true,
            xp = 250,
            connectedPaths = listOf("A", "B", "C")
        )
        composeRule.setContent { ProgressionIndicatorTagged(selectedNode = node) }

        composeRule.onNodeWithText("🎯 Node Progression").assertIsDisplayed()
        composeRule.onNodeWithText("Next: ${1000 - 250} XP").assertIsDisplayed()
        composeRule.onNodeWithText("Available Paths: 3").assertIsDisplayed()
    }
}
