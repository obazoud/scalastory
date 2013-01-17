package com.bazoud.scalastory

import org.scalatra._
import scalate.ScalateSupport

class ScalaStoryServlet extends ScalatraServlet with ScalateSupport {

  get("/") {
    try {
      params("q") match {
        case "Quelle est ton adresse email" => Ok("olivier.bazoud@gmail.com")
        case "Es tu heureux de participer(OUI/NON)" => Ok("OUI")
        case "Es tu abonne a la mailing list(OUI/NON)" => Ok("OUI")
        case "Es tu pret a recevoir une enonce au format markdown par http post(OUI/NON)" => Ok("OUI")
        case "Est ce que tu reponds toujours oui(OUI/NON)" => Ok("OUI")
        case _   => BadRequest("oops: " + params("q"))
      }
    } catch {
      case e:Exception =>
        notFound()
    }
  }

}
