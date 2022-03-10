import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    java
    application
    id("com.github.johnrengelman.shadow") version "7.1.2"
}

group = "nl.hhs.group8d"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}

val shadowJar by tasks.named<ShadowJar>("shadowJar") {
    manifest {
        attributes(mapOf(
            "Main-Class" to "com.martmists.project.Main"
        ))
    }
}

tasks.named("build") {
    dependsOn(shadowJar)
}


tasks.getByName<Test>("test") {
    useJUnitPlatform()
}
