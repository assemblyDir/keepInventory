import gradle.kotlin.dsl.accessors._8fef7488b4e13413a248f4aae2811a96.shadowJar

plugins {
    `maven-publish`
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = project.group.toString()
            version = project.version.toString()
            artifactId = project.name

            artifact(tasks.shadowJar.get())
        }
    }
}
