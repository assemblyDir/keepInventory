plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
    gradlePluginPortal()
}

dependencies {
    implementation("com.gradleup.shadow:com.gradleup.shadow.gradle.plugin:9.3.2")
    implementation("xyz.jpenilla.run-paper:xyz.jpenilla.run-paper.gradle.plugin:3.0.1")
}