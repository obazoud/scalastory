package com.bazoud.scalastory.rest

import org.scalatra._
import scalate.ScalateSupport
import grizzled.slf4j.Logger

class ScalaStoryServlet extends ScalatraServlet with ScalateSupport {
  private val logger: Logger = Logger[this.type]

  get("/") {
    val q = params.getOrElse("q", -1)
    logger.info("> q: " + q)
    q match {
      case "Quelle est ton adresse email"                                                 => Ok("olivier.bazoud@gmail.com")
      case "Es tu heureux de participer(OUI/NON)"                                         => Ok("OUI")
      case "Es tu abonne a la mailing list(OUI/NON)"                                      => Ok("OUI")
      case "Es tu pret a recevoir une enonce au format markdown par http post(OUI/NON)"   => Ok("OUI")
      case "Est ce que tu reponds toujours oui(OUI/NON)"                                  => Ok("NON")
      case "As tu bien recu le premier enonce(OUI/NON)"                                   => Ok("NON")
      case -1                                                                             => Ok("A Code Story server implementation.")
      case _                                                                              => BadRequest("oops: " + q)
    }
  }

  before() {
    logger.info("> requestPath: " + requestPath)
    logger.info("> queryString: " + request.queryString)
    logger.info("> body: " + request.body)
    params.foreach(arg => logger.info("> param " + arg._1 + " -> " + arg._2))
    request.headers.foreach(arg => logger.info("> header " + arg._1 + " -> " + arg._2))
  }

  error {
    case e: Exception =>
      logger.info("Unexpected error during http api call.", e)
      status_=(500)
  }
}
