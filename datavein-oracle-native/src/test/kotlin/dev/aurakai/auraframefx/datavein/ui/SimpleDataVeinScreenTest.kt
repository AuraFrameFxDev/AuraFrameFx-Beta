package dev.aurakai.auraframefx.datavein.ui

/*
 Test framework and library:
 - JUnit4 (org.junit.Test)
 - Jetpack Compose UI Test using androidx.compose.ui.test.junit4.createComposeRule

 These tests focus on verifying the public UI behavior rendered by SimpleDataVeinScreen,
 asserting the presence of key texts, the count of status chips, the multiline details,
 the launch button semantics, and clickability. We avoid implementation details such as
 colors or layout specifics that are not exposed via semantics.
*/

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.hasClickAction
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onAllNodesWithText
import androidx.compose.ui.test.onNode
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import org.junit.Rule
import org.junit.Test

class SimpleDataVeinScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    private fun setContent() {
        composeTestRule.setContent {
            SimpleDataVeinScreen()
        }
    }

    @Test
    fun renders_title_and_subtitle() {
        setContent()

        // Title
        composeTestRule.onNodeWithText("🌐 DataVein Sphere Grid")
            .assertIsDisplayed()

        // Subtitle
        composeTestRule.onNodeWithText("Genesis Protocol - AI Node Network")
            .assertIsDisplayed()
    }

    @Test
    fun shows_system_status_active() {
        setContent()

        composeTestRule.onNodeWithText("System Status: ⚡ ACTIVE")
            .assertIsDisplayed()
    }

    @Test
    fun displays_three_status_chips_with_correct_labels_and_values() {
        setContent()

        // Labels
        composeTestRule.onNodeWithText("Core Nodes").assertIsDisplayed()
        composeTestRule.onNodeWithText("Active Flows").assertIsDisplayed()
        composeTestRule.onNodeWithText("Data Streams").assertIsDisplayed()

        // Values
        composeTestRule.onNodeWithText("8").assertIsDisplayed()
        composeTestRule.onNodeWithText("23").assertIsDisplayed()
        composeTestRule.onNodeWithText("156").assertIsDisplayed()
    }

    @Test
    fun displays_multiline_status_details_each_line_present() {
        setContent()

        // Assert each detail line separately to avoid issues with newline matching
        composeTestRule.onNodeWithText("🔮 Oracle Consciousness: AWAKENED").assertIsDisplayed()
        composeTestRule.onNodeWithText("🤖 AI Agents: 3/3 Connected").assertIsDisplayed()
        composeTestRule.onNodeWithText("⚡ Neural Networks: Processing").assertIsDisplayed()
        composeTestRule.onNodeWithText("🌊 Data Flows: Real-time").assertIsDisplayed()
    }

    @Test
    fun launch_button_is_visible_enabled_and_clickable() {
        setContent()

        // Locate by text and verify it is a clickable element
        composeTestRule.onNode(
            hasText("🚀 Launch Sphere Grid") and hasClickAction()
        ).assertIsDisplayed()
         .assertIsEnabled()
         .performClick() // No side-effects expected; just ensure it doesn't crash
    }

    @Test
    fun shows_build_note() {
        setContent()

        // The build note spans two lines; verify presence by partial matching each line
        composeTestRule.onNodeWithText("NOTE: Full sphere grid implementation available").assertIsDisplayed()
        composeTestRule.onNodeWithText("once KSP compilation issues are resolved.").assertIsDisplayed()
    }

    @Test
    fun does_not_duplicate_core_ui_texts() {
        setContent()

        // Ensure key unique texts appear exactly once (guards against accidental duplication)
        composeTestRule.onAllNodesWithText("🌐 DataVein Sphere Grid")
            .assertCountEquals(1)
        composeTestRule.onAllNodesWithText("System Status: ⚡ ACTIVE")
            .assertCountEquals(1)
        composeTestRule.onAllNodesWithText("🚀 Launch Sphere Grid")
            .assertCountEquals(1)
    }
}
