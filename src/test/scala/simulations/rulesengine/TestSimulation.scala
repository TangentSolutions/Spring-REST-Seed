package computerdatabase // 1

import io.gatling.core.Predef._ // 2
import io.gatling.http.Predef._
import scala.concurrent.duration._

class TestSimulation extends Simulation { // 3

  val httpConf = http // 4
    .baseURL("http://localhost:8001") // 5

  val scn = scenario("TestSimulation") // 7
    .exec(http("get_home")  
      .get("/metrics/")) 
    .pause(5) 
    .exec(http("get_health")  
      .get("/health/"))

  setUp( // 11
    scn.inject(rampUsers(30) over (10 seconds)) // 12
  ).protocols(httpConf) // 13
}
