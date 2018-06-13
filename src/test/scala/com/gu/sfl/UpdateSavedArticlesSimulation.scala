package com.gu.sfl

import io.gatling.core.Predef.{rampUsers, scenario}
import scala.concurrent.duration._


class UpdateSavedArticlesSimulation extends SaveForLaterSimulation {

  val scenarioName = "SaveArticles"

  val scn = scenario(scenarioName)
    .exec(
      TaskTesks.updateArticlesTask
    )

  // set up the scenario and threads (users) count:
  setUp(scn.inject(rampUsers(25) over (1 minute)))
    .protocols(httpProtocol)

}
