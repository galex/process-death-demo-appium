package dev.galex.process.death.appium.extensions

import dev.galex.process.death.appium.AppiumSetup.Companion.ACTIVITY_NAME
import dev.galex.process.death.appium.AppiumSetup.Companion.PACKAGE_NAME
import io.appium.java_client.android.AndroidDriver

fun AndroidDriver.killApp() {
    val args = listOf("kill", PACKAGE_NAME)
    val command = mapOf(
        "command" to "am",
        "args" to args
    )

    executeScript("mobile: shell", command)
}

fun AndroidDriver.restart() {

    val args = listOf("start", "$PACKAGE_NAME/$ACTIVITY_NAME")
    val command = mapOf(
        "command" to "am",
        "args" to args
    )

    executeScript("mobile: shell", command)
}
