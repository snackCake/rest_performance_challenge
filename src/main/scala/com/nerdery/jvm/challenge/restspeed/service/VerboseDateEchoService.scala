package com.nerdery.jvm.challenge.restspeed.service

import java.time.LocalDate
import javax.inject.Singleton

import com.nerdery.jvm.challenge.restspeed.model.request.EchoRequest
import com.nerdery.jvm.challenge.restspeed.model.response.DateEchoResponse

/**
  * VerboseDateEchoService performs the "business logic" of transforming requested data.
  *
  * @author Josh Klun (jklun@nerdery.com)
  */
@Singleton
class VerboseDateEchoService {

  def echo(request: EchoRequest): DateEchoResponse = {
    val now = LocalDate.now
    DateEchoResponse(
      request.name,
      request.message.toUpperCase,
      request.number * request.number,
      now.getYear,
      now.getMonthValue,
      now.getDayOfMonth)
  }

}
