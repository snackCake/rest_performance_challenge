package com.nerdery.jvm.challenge.restspeed.controller

import javax.inject.Inject

import com.nerdery.jvm.challenge.restspeed.model.request.EchoRequest
import com.nerdery.jvm.challenge.restspeed.service.VerboseDateEchoService
import com.twitter.finatra.http.Controller

/**
  * VerboseDateEchoController handles a single GET request on the /echo URL path.
  *
  * @author Josh Klun (jklun@nerdery.com)
  */
class VerboseDateEchoController @Inject()(echoService: VerboseDateEchoService) extends Controller {

  get("/echo") { request: EchoRequest =>
    info(s"echo: $request")
    response.ok(echoService.echo(request))
  }

}
