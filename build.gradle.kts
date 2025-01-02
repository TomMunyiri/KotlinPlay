import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
val gsonVersion = "2.9.0"
plugins {
    //kotlin("jvm") version "1.5.10"
    kotlin("jvm") version "2.0.0"
}

group = "me.tmwangi"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    api("com.google.code.gson:gson:$gsonVersion")
    implementation(kotlin("stdlib-jdk8"))
    implementation("org.json:json:20240303")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.8.1")
    implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.6.0")
}

tasks.test {
    useJUnit()
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "1.8"
}
val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
    jvmTarget = "1.8"
}
val compileTestKotlin: KotlinCompile by tasks
compileTestKotlin.kotlinOptions {
    jvmTarget = "1.8"
}