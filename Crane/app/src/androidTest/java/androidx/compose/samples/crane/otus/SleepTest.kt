package androidx.compose.samples.crane.otus

import android.graphics.Bitmap
import androidx.compose.samples.crane.home.MainActivity
import androidx.compose.samples.crane.home.MainScreen
import androidx.compose.ui.graphics.asAndroidBitmap
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.ComposeContentTestRule
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.navigation.testing.TestNavHostController
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.io.FileOutputStream
import java.util.*

//@RunWith(AndroidJUnit4::class)
@HiltAndroidTest
class UITests {

    @get:Rule(order = 0)
    var hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun sleepTest() {
        //val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        //assertEquals("androidx.compose.samples.crane", appContext.packageName)
        composeTestRule.setContent {
            MainScreen({ }, { })
        }

        composeTestRule.onRoot().printToLog("test")

        composeTestRule.takeScreenshot()
        composeTestRule.onNode(hasText("SLEEP")).performClick()
        composeTestRule.onNode(hasText("1 Adult")).performClick()
        composeTestRule.takeScreenshot()
        composeTestRule.onNode(hasText("2 Adults")).assertIsDisplayed()
        composeTestRule.takeScreenshot()
        composeTestRule.onNodeWithText("Maldivas, South Asia")
            .assertIsDisplayed().performClick()
        composeTestRule.takeScreenshot()
        composeTestRule.onNodeWithText("Maldivas, South Asia").assertIsDisplayed()
    }


}

private fun ComposeContentTestRule.takeScreenshot() {
    onRoot()
        .captureToImage()
        .asAndroidBitmap()
        .save("${UUID.randomUUID()}")
}

private fun Bitmap.save(filename: String) {
    val path = InstrumentationRegistry.getInstrumentation().targetContext.filesDir.canonicalPath
    FileOutputStream("$path/$filename.png").use { out ->
        compress(Bitmap.CompressFormat.PNG, 100, out)
    }
}
