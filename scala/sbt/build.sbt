val gatlingVersion = "3.15.1"
val gatlingMqttVersion = "3.15.1"

lazy val gatlingSbtPluginDemo = rootProject
  .enablePlugins(GatlingPlugin)
  .settings(
    name := "gatling-mqtt-demo-sbt-scala",
    scalaVersion := "2.13.18",
    scalacOptions := Seq(
      "-encoding", "UTF-8", "-release:8", "-deprecation",
      "-feature", "-unchecked", "-language:implicitConversions", "-language:postfixOps"),
    libraryDependencies ++= Seq(
      "io.gatling.highcharts" % "gatling-charts-highcharts" % gatlingVersion % "test",
      "io.gatling"            % "gatling-mqtt"              % gatlingMqttVersion % "test",
      "io.gatling"            % "gatling-test-framework"    % gatlingVersion % "test")
  )
