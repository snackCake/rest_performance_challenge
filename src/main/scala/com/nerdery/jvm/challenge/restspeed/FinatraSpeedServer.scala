package com.nerdery.jvm.challenge.restspeed

import com.nerdery.jvm.challenge.restspeed.controller.VerboseDateEchoController
import com.twitter.finagle.http.{Response, Request}
import com.twitter.finatra.http.HttpServer
import com.twitter.finatra.http.filters.{CommonFilters, TraceIdMDCFilter, LoggingMDCFilter}
import com.twitter.finatra.http.routing.HttpRouter

/**
  * FinatraSpeedServer configures the HTTP server and FinatraSpeedServerMain serves as the main() object for the application.
  *
  * @author Josh Klun (jklun@nerdery.com)
  */
object FinatraSpeedServerMain extends FinatraSpeedServer

class FinatraSpeedServer extends HttpServer {

  override def configureHttp(router: HttpRouter) {
    router
      .filter[LoggingMDCFilter[Request, Response]]
      .filter[TraceIdMDCFilter[Request, Response]]
      .filter[CommonFilters]
      .add[VerboseDateEchoController]
  }
}