package com.nerdery.jvm.challenge.restspeed.model.request

import com.twitter.finatra.request.QueryParam

/**
  * @author Josh Klun (jklun@nerdery.com)
  */
case class EchoRequest(@QueryParam name: String, @QueryParam message: String, @QueryParam number: Int)
