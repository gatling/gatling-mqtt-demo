plugins {
  idea
  kotlin("jvm")               version "2.1.0"
  kotlin("plugin.allopen")    version "2.1.0"

  id("com.diffplug.spotless") version "6.25.0"
  id("io.gatling.gradle")     version "3.13.1.2"
}

repositories {
  mavenCentral()
}

dependencies {
  gatlingImplementation("io.gatling:gatling-mqtt-java:3.13.1.2")
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
