enablePlugins(GatlingPlugin)

name := "gatling-mqtt-demo-sbt-scala"

scalaVersion := "2.13.13"
scalacOptions := Seq(
  "-encoding", "UTF-8", "-release:8", "-deprecation",
  "-feature", "-unchecked", "-language:implicitConversions", "-language:postfixOps")

val gatlingVersion = "3.11.1"
val gatlingMqttVersion = "3.11.1"

libraryDependencies += "io.gatling.highcharts" % "gatling-charts-highcharts" % gatlingVersion     % "test,it"
libraryDependencies += "io.gatling"            % "gatling-mqtt"              % gatlingMqttVersion % "test,it"
libraryDependencies += "io.gatling"            % "gatling-test-framework"    % gatlingVersion     % "test,it"

// Enterprise Cloud (https://cloud.gatling.io/) configuration reference: https://gatling.io/docs/gatling/reference/current/extensions/sbt_plugin/#working-with-gatling-enterprise-cloud
// Enterprise Self-Hosted configuration reference: https://gatling.io/docs/gatling/reference/current/extensions/sbt_plugin/#working-with-gatling-enterprise-self-hosted
