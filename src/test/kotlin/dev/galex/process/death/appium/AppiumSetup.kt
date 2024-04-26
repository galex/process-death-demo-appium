package dev.galex.process.death.appium

import io.appium.java_client.AppiumDriver
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.android.options.UiAutomator2Options
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.openqa.selenium.remote.CapabilityType
import org.openqa.selenium.remote.DesiredCapabilities
import java.net.URL


open class AppiumSetup {

    companion object {

        const val ACTIVITY_NAME = "dev.galex.process.death.demo.MainActivity"
        const val PACKAGE_NAME = "dev.galex.process.death.demo"
        private const val AUTOMATION_NAME = "UiAutomator2"
        private const val PLATFORM_NAME = "Android"
        private const val SERVER_URL = "http://127.0.0.1:4723"

        lateinit var driver: AndroidDriver


        @JvmStatic
        @BeforeAll
        fun setUp() {

            val options = UiAutomator2Options()
                .setPlatformName(PLATFORM_NAME)
                .setAppPackage(PACKAGE_NAME)
                .setAutomationName(AUTOMATION_NAME)
                .setAppActivity(ACTIVITY_NAME)
                .setAutoGrantPermissions(true)

            driver = AndroidDriver(URL(SERVER_URL), options)
            driver.activateApp(PACKAGE_NAME)
        }

        @JvmStatic
        @AfterAll
        fun tearDown() {
            driver.quit()
        }
    }
}