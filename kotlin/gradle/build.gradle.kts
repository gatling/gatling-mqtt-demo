plugins {
  idea
  kotlin("jvm")               version "2.0.21"
  kotlin("plugin.allopen")    version "2.0.21"

  id("com.diffplug.spotless") version "6.25.0"
  id("io.gatling.gradle")     version "3.12.0.3"
}

repositories {
  mavenCentral()
}

dependencies {
  gatlingImplementation("io.gatling:gatling-mqtt-java:3.12.0.1")
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
