package com.bazoud.scalastory

import org.scalatra._
import scalate.ScalateSupport

class ScalaStoryServlet extends ScalatraServlet with ScalateSupport {

  get("/") {
    try {
      params("q") match {
        case "Quelle est ton adresse email" => Ok("olivier.bazoud@gmail.com")
        case "Es tu heureux de participer(OUI/NON)" => Ok("OUI")
        case _   => BadRequest("oops: " + params("q"))
      }
    } catch {
      case e:Exception =>
        notFound()
    }
  }

}
