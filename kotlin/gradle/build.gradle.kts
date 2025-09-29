plugins {
  idea
  kotlin("jvm")               version "2.2.20"
  kotlin("plugin.allopen")    version "2.2.20"

  id("com.diffplug.spotless") version "8.0.0"
  id("io.gatling.gradle")     version "3.14.5"
}

repositories {
  mavenCentral()
}

dependencies {
  gatlingImplementation("io.gatling:gatling-mqtt-java:3.14.5")
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
