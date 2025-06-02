plugins {
  idea
  kotlin("jvm")               version "2.1.21"
  kotlin("plugin.allopen")    version "2.1.21"

  id("com.diffplug.spotless") version "7.0.4"
  id("io.gatling.gradle")     version "3.14.3"
}

repositories {
  mavenCentral()
}

dependencies {
  gatlingImplementation("io.gatling:gatling-mqtt-java:3.14.3")
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
