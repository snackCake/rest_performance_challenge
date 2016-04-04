package com.nerdery.jvm.challenge.restspeed.model.response

/**
  * DateEchoResponse contains the data in a JSON response.
  *
  * @author Josh Klun (jklun@nerdery.com)
  */
case class DateEchoResponse(name: String, capitalizedMessage: String, squaredNumber: Int, year: Int, month: Int, day: Int)
