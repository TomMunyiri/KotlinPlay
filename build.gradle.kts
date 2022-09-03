import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
val gsonVersion = "2.9.0"
plugins {
    kotlin("jvm") version "1.5.10"
}

group = "me.tmwangi"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    api("com.google.code.gson:gson:$gsonVersion")
}

tasks.test {
    useJUnit()
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "1.8"
}