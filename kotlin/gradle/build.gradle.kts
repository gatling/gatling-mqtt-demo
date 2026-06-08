plugins {
  idea
  kotlin("jvm")               version "2.4.0"
  kotlin("plugin.allopen")    version "2.4.0"

  id("com.diffplug.spotless") version "8.6.0"
  id("io.gatling.gradle")     version "3.15.1"
}

tasks.withType(JavaCompile::class) {
  options.release.set(21)
}

kotlin {
  compilerOptions {
    jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_21)
  }
}

repositories {
  mavenCentral()
}

dependencies {
  gatlingImplementation("io.gatling:gatling-mqtt-java:3.15.1")
}

gatling {
  // Enterprise Cloud (https://cloud.gatling.io/) configuration reference: https://docs.gatling.io/reference/integrations/build-tools/gradle-plugin/#running-your-simulations-on-gatling-enterprise-cloud
}

spotless {
  kotlin {
    ktfmt()
      .googleStyle()
  }
}
