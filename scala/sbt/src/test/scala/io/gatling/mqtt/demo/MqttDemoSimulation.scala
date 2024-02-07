package io.gatling.mqtt.demo

import java.util.UUID

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.mqtt.Predef._

class MqttDemoSimulation extends Simulation {

  // Example using HiveMQ's free public MQTT broker: https://www.hivemq.com/mqtt/public-mqtt-broker/
  private val baseMqttProtocol =
    mqtt.broker("broker.hivemq.com", 8883)
      .useTls(true)
      .correlateBy(jmesPath("id"))

  private val topic = s"gatling-mqtt-demo/${UUID.randomUUID}"

  private val scn = scenario("Publisher")
    .exec(_.set("id", UUID.randomUUID))
    .exec(
      mqtt("Connecting").connect,
      mqtt("Subscribing")
        .subscribe(topic),
      mqtt("Publishing")
        .publish(topic)
        .message(StringBody("""{"id":"#{id}","message":"Hello from #{id}"}"""))
        .await(1.second)
        .check(jmesPath("message").is("Hello from #{id}"))
    )

  // sbt "Gatling / testOnly io.gatling.mqtt.demo.MqttDemoSimulation"

  setUp(
    scn.inject(atOnceUsers(5)),
  ).protocols(baseMqttProtocol)
}
