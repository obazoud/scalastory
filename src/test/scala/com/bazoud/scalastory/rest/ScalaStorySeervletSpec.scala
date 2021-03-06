package com.bazoud.scalastory.rest

import org.scalatra.test.specs2._

class ScalaStoryServletSpec extends MutableScalatraSpec {

  addServlet(classOf[ScalaStoryServlet], "/*")

  "GET / on ScalaStoryServlet" should {
    "return status 200" in {
      get("/") {
        status must_== 200
      }
    }
  }

  "GET /?q=Quelle+est+ton+adresse+email on ScalaStoryServlet" should {
    "return status 200" in {
      get("/?q=Quelle+est+ton+adresse+email") {
        status must_== 200
        body must_== "olivier.bazoud@gmail.com"
      }
    }
  }

  "GET /?q=wtf on ScalaStoryServlet" should {
    "return status 400" in {
      get("/?q=wtf") {
        status must_== 400
      }
    }
  }

  "GET /?q=Es+tu+heureux+de+participer(OUI/NON) on ScalaStoryServlet" should {
    "return status 200" in {
      get("/?q=Es+tu+heureux+de+participer(OUI/NON)") {
        status must_== 200
        body must_== "OUI"
      }
    }
  }

  "GET /?q=Es+tu+abonne+a+la+mailing+list(OUI/NON) on ScalaStoryServlet" should {
    "return status 200" in {
      get("/?q=Es+tu+abonne+a+la+mailing+list(OUI/NON)") {
        status must_== 200
        body must_== "OUI"
      }
    }
  }

  "GET /?q=Es+tu+pret+a+recevoir+une+enonce+au+format+markdown+par+http+post(OUI/NON) on ScalaStoryServlet" should {
    "return status 200" in {
      get("/?q=Es+tu+pret+a+recevoir+une+enonce+au+format+markdown+par+http+post(OUI/NON)") {
        status must_== 200
        body must_== "OUI"
      }
    }
  }

  "GET /?q=Est+ce+que+tu+reponds+toujours+oui(OUI/NON) on ScalaStoryServlet" should {
    "return status 200" in {
      get("/?q=Est+ce+que+tu+reponds+toujours+oui(OUI/NON)") {
        status must_== 200
        body must_== "NON"
      }
    }
  }
}
