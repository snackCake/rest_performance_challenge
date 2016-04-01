package com.nerdery.jvm.challenge.restspeed.test

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class EchoSimulation extends Simulation {

	val httpProtocol = http
		.baseURL("http://localhost:8888")
		.inferHtmlResources()

	val headers_0 = Map("Upgrade-Insecure-Requests" -> "1")

    val uri1 = "http://localhost:8888/echo"

	val scn = scenario("EchoSimulation")
		.exec(http("request_0")
			.get("/echo?message=x&name=y&number=3")
			.headers(headers_0))
		.pause(1)
		.exec(http("request_1")
			.get("/echo?message=x&name=y&number=3")
			.headers(headers_0))
		.pause(2)
		.exec(http("request_2")
			.get("/echo?message=x&name=y&number=3")
			.headers(headers_0)
			.resources(http("request_3")
			.get(uri1 + "?message=x&name=y&number=3")
			.headers(headers_0)))
		.pause(30)
		.exec(http("request_4")
			.get("/echo?message=%22This%20is%20a%20test%20of%20the%20emergency%20something%20something%22&name=jklun&number=1234567890")
			.headers(headers_0))

	setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}