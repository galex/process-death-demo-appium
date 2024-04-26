plugins {
    kotlin("jvm") version "1.9.23"
}

group = "process.death.demo.appium"
version = "0.0.1"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.2")
    testImplementation("io.appium:java-client:9.2.2")
    testImplementation("org.seleniumhq.selenium:selenium-java:4.20.0")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(15)
}