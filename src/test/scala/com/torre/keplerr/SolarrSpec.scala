package com.torre.keplerr

import org.scalatra.test.specs2._

// For more on Specs2, see http://etorreborre.github.com/specs2/guide/org.specs2.guide.QuickStart.html
class SolarrSpec extends ScalatraSpec { def is =
  "GET / on Solarr"                     ^
    "should return status 200"                  ! root200^
                                                end

  addServlet(classOf[Solarr], "/*")

  def root200 = get("/") {
    status must_== 200
  }
}
