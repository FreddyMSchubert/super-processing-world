plugins {
    id("java")
    id("application")
}

group = "com.frederickschubert"
version = "1.0-SNAPSHOT"

java {
    // Processing 4 targets Java 17
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

repositories {
    mavenCentral()
    maven(url = "https://jogamp.org/deployment/maven/")
}

dependencies {
    implementation("org.processing:core:4.4.7")
}

application {
    mainClass.set("com.frederickschubert.superprocessingworld.Main")
}
