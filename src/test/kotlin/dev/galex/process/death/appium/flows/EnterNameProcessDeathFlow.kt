package dev.galex.process.death.appium.flows

import dev.galex.process.death.appium.AppiumSetup
import dev.galex.process.death.appium.extensions.killApp
import dev.galex.process.death.appium.extensions.restart
import dev.galex.process.death.appium.extensions.triggerProcessDeath
import io.appium.java_client.AppiumBy
import io.appium.java_client.android.nativekey.AndroidKey
import io.appium.java_client.android.nativekey.KeyEvent
import org.junit.jupiter.api.Test
import org.openqa.selenium.WebElement
import kotlin.test.assertEquals
import kotlin.test.assertNotNull


class EnterNameProcessDeathFlow : AppiumSetup() {

    @Test
    fun `Basic Flow + Process Death`() {

        // Finds the TextView
        val textView: WebElement = driver.findElement(AppiumBy.id("dev.galex.process.death.demo:id/enter_name"))
        assertNotNull(textView)
        // Fills it up with "John Doe"
        textView.sendKeys("John Doe")

        // Finds the Button "next" and clicks on it
        val button = driver.findElement(AppiumBy.id("dev.galex.process.death.demo:id/next"))
        // Clicks on the button
        button.click()

        // Puts app in background
        driver.pressKey(KeyEvent(AndroidKey.HOME))

        // Trigger Process Death (kill + restart app)
        driver.triggerProcessDeath()

        // Gets the string presented in the ShowName TextView
        val showNameText = driver.findElement(AppiumBy.id("dev.galex.process.death.demo:id/show_name")).text

        // We should also be getting "Name = John Doe in this case, but we're getting "Name = null" so this assertion fails
        assertEquals("Name = John Doe", showNameText)
    }
}