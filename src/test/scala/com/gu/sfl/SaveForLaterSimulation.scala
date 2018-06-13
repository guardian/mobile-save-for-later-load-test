package com.gu.sfl

import io.gatling.core.Predef._
import io.gatling.http.Predef._

class SaveForLaterSimulation extends Simulation {

 // val scenarioName = "SaveArticles"
  val headers = Map(
    "Host" -> "mobile-save-for-later.mobile-aws.code.dev-guardianapis.com",
    "Accept" ->  "*/*",
    "User-Agent" -> "Guardian/16444 CFNetwork/808.3 Darwin/16.3.0",
    "Accept-Language" ->  "en-gb",
    "Pragma" -> "no-cache",
    "Cache-Control" -> "no-cache",
    "Authorization" -> "Bearer b8bb3036199b97717a0331e2729b8f78bc91577ef0e4815ab692465fd47ac3c2"
  )
  val httpProtocol = http
      .baseURL("https://mobile-save-for-later.mobile-aws.code.dev-guardianapis.com")
        .headers(headers)

}
