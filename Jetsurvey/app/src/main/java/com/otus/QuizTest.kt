package com.otus

import org.junit.Rule
import org.junit.Test
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.runner.RunWith
import androidx.compose.ui.test.junit4.createComposeRule


@RunWith(AndroidJUnit4::class)
class QuizTest {
    @get:Rule
    val composeTestRule = createComposeRule()
    //val composeTestRule2 = createAndroidComposeRule<MainActivity>()

    @Test
    fun quizTest() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        composeTestRule.setContent{
        }


    }

}

