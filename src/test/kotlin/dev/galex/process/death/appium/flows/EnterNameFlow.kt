package dev.galex.process.death.appium.flows

import dev.galex.process.death.appium.utils.BaseAppiumTest
import io.appium.java_client.AppiumBy
import org.junit.jupiter.api.Test
import org.openqa.selenium.WebElement
import kotlin.test.assertEquals
import kotlin.test.assertNotNull


class EnterNameFlow: BaseAppiumTest() {

    @Test
    fun `Basic Happy Flow`() {

        // Finds the TextView
        val textView: WebElement = driver.findElement(AppiumBy.id("dev.galex.process.death.demo:id/enter_name"))
        assertNotNull(textView)
        // Fills it up with "John Doe"
        textView.sendKeys("John Doe")

        // Finds the Button "next" and clicks on it
        val button = driver.findElement(AppiumBy.id("dev.galex.process.death.demo:id/next"))
        // Clicks on the button
        button.click()

        // Gets the string presented in the ShowName TextView
        val showNameText = driver.findElement(AppiumBy.id("dev.galex.process.death.demo:id/show_name")).text

        // Checks that we really see what we expect in this screen
        assertEquals("Name = John Doe", showNameText)
    }
}