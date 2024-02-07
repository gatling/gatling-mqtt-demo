package io.gatling.mqtt.demo;

import java.time.Duration;
import java.util.UUID;

import io.gatling.javaapi.core.*;
import io.gatling.javaapi.mqtt.*;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.mqtt.MqttDsl.*;

public class MqttDemoSimulation extends Simulation {

  // Example using HiveMQ's free public MQTT broker: https://www.hivemq.com/mqtt/public-mqtt-broker/
  MqttProtocolBuilder baseMqttProtocol =
    mqtt.broker("broker.hivemq.com", 8883)
      .useTls(true)
      .correlateBy(jmesPath("id"));

  String topic = "gatling-mqtt-demo/" + UUID.randomUUID();

  ScenarioBuilder scn = scenario("Publisher")
    .exec(session -> session.set("id", UUID.randomUUID()))
    .exec(
      mqtt("Connecting").connect(),
      mqtt("Subscribing")
        .subscribe(topic),
      mqtt("Publishing")
        .publish(topic)
        .message(StringBody("{\"id\":\"#{id}\",\"message\":\"Hello from #{id}\"}"))
        .await(Duration.ofSeconds(1))
        .check(jmesPath("message").isEL("Hello from #{id}"))
    );

  // ./gradlew gatlingRun-io.gatling.mqtt.demo.MqttDemoSimulation

  {
    setUp(
      scn.injectOpen(atOnceUsers(5))
    ).protocols(baseMqttProtocol);
  }
}
