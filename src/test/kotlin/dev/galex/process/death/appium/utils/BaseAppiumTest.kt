package dev.galex.process.death.appium.utils

import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.android.options.UiAutomator2Options
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.openqa.selenium.remote.CapabilityType.PLATFORM_NAME
import java.net.URL


open class BaseAppiumTest {

    companion object {

        lateinit var driver: AndroidDriver

        @JvmStatic
        @BeforeAll
        fun setUp() {
            //
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