enablePlugins(GatlingPlugin)

name := "gatling-mqtt-demo-sbt-scala"

scalaVersion := "2.13.16"
scalacOptions := Seq(
  "-encoding", "UTF-8", "-release:8", "-deprecation",
  "-feature", "-unchecked", "-language:implicitConversions", "-language:postfixOps")

val gatlingVersion = "3.14.3"
val gatlingMqttVersion = "3.14.3"

libraryDependencies += "io.gatling.highcharts" % "gatling-charts-highcharts" % gatlingVersion     % "test,it"
libraryDependencies += "io.gatling"            % "gatling-mqtt"              % gatlingMqttVersion % "test,it"
libraryDependencies += "io.gatling"            % "gatling-test-framework"    % gatlingVersion     % "test,it"

// Enterprise Cloud (https://cloud.gatling.io/) configuration reference: https://docs.gatling.io/reference/integrations/build-tools/sbt-plugin/#running-your-simulations-on-gatling-enterprise-cloud
