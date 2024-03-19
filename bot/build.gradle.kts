// Gradle file that controls the build of the Discord bot and execution in dev environment.

plugins {
    id("application")
    kotlin("jvm") version "1.9.23";
}

kotlin {
    jvmToolchain(21)
}

repositories {
    mavenCentral()
}

application {
    mainClass = "KhorumeBot.Bot.MainKt"
}

sourceSets.main {
    java.srcDirs("src/main/kotlin");
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.9.23")
    implementation("org.javacord:javacord:3.8.0");
}