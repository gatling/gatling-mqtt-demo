plugins {
  idea
  kotlin("jvm")               version "1.9.23"
  kotlin("plugin.allopen")    version "1.9.23"

  id("com.diffplug.spotless") version "6.25.0"
  id("io.gatling.gradle")     version "3.10.5"
}

repositories {
  mavenCentral()
}

dependencies {
  gatlingImplementation("io.gatling:gatling-mqtt-java:3.10.5.1")
}

gatling {
  // Enterprise Cloud (https://cloud.gatling.io/) configuration reference: https://gatling.io/docs/gatling/reference/current/extensions/gradle_plugin/#working-with-gatling-enterprise-cloud
  // Enterprise Self-Hosted configuration reference: https://gatling.io/docs/gatling/reference/current/extensions/gradle_plugin/#working-with-gatling-enterprise-self-hosted
}

spotless {
  kotlin {
    ktfmt()
      .googleStyle()
  }
}
