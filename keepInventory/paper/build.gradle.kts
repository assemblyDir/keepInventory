plugins {
    `java-convention`
    `paper-convention`
    `publishing-convention`
}

dependencies {
    implementation(project(":keepInventory:api"))
}

tasks.compileJava {
    dependsOn(":keepInventory:api:shadowJar")
}
