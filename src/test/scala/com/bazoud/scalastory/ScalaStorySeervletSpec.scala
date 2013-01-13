package com.bazoud.scalastory

import org.scalatra.test.specs2._

// For more on Specs2, see http://etorreborre.github.com/specs2/guide/org.specs2.guide.QuickStart.html
class ScalaStorySeervletSpec extends ScalatraSpec { def is =
  "GET / on ScalaStorySeervlet"                     ^
    "should return status 200"                  ! root200^
                                                end

  addServlet(classOf[ScalaStoryServlet], "/*")

  def root200 = get("/") {
    status must_== 200
  }

  def query_q_mail = get("/?q=Quelle est ton adresse email") {
    status must_== 200
    response must_== "olivier.bazoud@gmail.com"
  }

  def query_q_wtf = get("/?q=wtf") {
    status must_== 403
  }
}
