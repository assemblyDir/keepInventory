plugins {
    id("java")
    id("xyz.jpenilla.run-paper")
}

val minecraft = "1.21.11"

repositories {
    maven("https://repo.papermc.io/repository/maven-public/")
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:$minecraft-R0.1-SNAPSHOT")
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