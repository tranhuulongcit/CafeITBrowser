import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.4.10"
    application
    id("org.openjfx.javafxplugin") version "0.0.9"
    id("org.beryx.jlink") version "2.22.1"
}

val compileKotlin: KotlinCompile by tasks
val compileJava: JavaCompile by tasks
compileJava.destinationDir = compileKotlin.destinationDir

application {
    mainModule.set("cafeit.browser")
    mainClass.set("info.cafeit.CafeITBrowser")
}

repositories {
    mavenCentral()
}

javafx {
    modules = listOf("javafx.controls", "javafx.fxml", "javafx.web")
}

jlink{
    launcher {
        name = "CafeitBrowser"
    }
    imageZip.set(project.file("${project.buildDir}/image-zip/cafeitbrowser.zip"))
}
