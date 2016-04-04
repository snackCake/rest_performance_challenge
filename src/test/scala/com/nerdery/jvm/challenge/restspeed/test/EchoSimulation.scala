package com.nerdery.jvm.challenge.restspeed.test

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

/**
  * Simple Gatling simulation for the REST service in this project. By default, it ramps to 3600 users in 15 seconds.
  *
  * @author Josh Klun (jklun@nerdery.com)
  */
class EchoSimulation extends Simulation {

  private val concurrentUsers = 3600
  private val rampSeconds = 15
  private val baseUrl = "http://localhost:8888"

  val httpProtocol = http
    .baseURL(baseUrl)
    .inferHtmlResources()
  val headers_0 = Map("Upgrade-Insecure-Requests" -> "1")

  val scn = scenario("EchoSimulation")
    .exec(http("request_0")
      .get("/echo?message=%22Copy,%20Gold%20Leader%20I%27m%20already%20on%20my%20way%20out%22&name=Wedge&number=3")
      .headers(headers_0))
    .pause(3)
    .exec(http("request_1")
      .get("/echo?message=%22It%20will%20be%20like%20old%20times%20Luke%22&name=Biggs&number=3")
      .headers(headers_0))
    .pause(2)
    .exec(http("request_2")
      .get("/echo?message=%22I'm%20right%20with%20you%20Red%20three%22&name=Porkins&number=3")
      .headers(headers_0))
    .pause(1)
    .exec(http("request_3")
      .get("/echo?message=You%20need%20a%20pilot&name=Poe&number=3")
      .headers(headers_0))
    .pause(5)
    .exec(http("request_4")
      .get("/echo?message=I%20used%20to%20bullseye%20womp%20rats%20in%20my%20T-16%20back%20home%20they%27re%20not%20much%20bigger%20than%20two%20meters&name=Luke&number=1234567890")
      .headers(headers_0))

  private val userRamp = rampUsers(concurrentUsers) over (rampSeconds seconds)
  setUp(scn.inject(userRamp)).protocols(httpProtocol)
}