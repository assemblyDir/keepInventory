plugins {
    id("java")
    id("xyz.jpenilla.run-paper") version "3.0.1"
}

group = "com.github.assemblyDir.keepInventory"
version = "1.0.0"

val minecraft = "1.21.11"
val java = 21

repositories {
    maven("https://repo.papermc.io/repository/maven-public/")
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:$minecraft-R0.1-SNAPSHOT")
}

java {
    toolchain.languageVersion = JavaLanguageVersion.of(java)
}

tasks.withType<JavaCompile>().configureEach {
    options.encoding = "UTF-8"
    options.release = java
}

tasks.runServer {
    minecraftVersion(minecraft)
}

tasks.processResources {
    val properties = mapOf(
        "name" to rootProject.name,
        "version" to project.version,
        "main" to "${project.group}.KeepInventory",
        "minecraft_version" to minecraft,
    )
    inputs.properties(properties)
    filteringCharset = "UTF-8"
    filesMatching("paper-plugin.yml") {
        expand(properties)
    }
}
