package androidx.compose.samples.crane.otus

import androidx.compose.samples.crane.home.MainActivity
import androidx.compose.samples.crane.home.MainScreen
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Rule
import org.junit.Test

@HiltAndroidTest
class EatTest {
    @get:Rule(order = 0)
    var hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun eatTest() {
        composeTestRule.setContent {
            MainScreen({ }, { })
        }

        composeTestRule.onNode(hasText("EAT")).performClick()
        composeTestRule.onNode(hasText("1 Adult")).performClick()
        composeTestRule.onNode(hasText("2 Adults")).assertIsDisplayed().performClick()
        composeTestRule.onNode(hasText("3 Adults")).assertIsDisplayed()
        composeTestRule.onNodeWithText("Naples, Italy")
            .assertIsDisplayed().performClick()
        composeTestRule.onNodeWithText("Naples, Italy").assertIsDisplayed()
    }
}
