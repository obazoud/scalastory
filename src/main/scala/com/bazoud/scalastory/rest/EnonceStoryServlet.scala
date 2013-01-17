package com.bazoud.scalastory.rest

import org.scalatra._
import grizzled.slf4j.Logger
import scalate.ScalateSupport

class EnonceStoryServlet extends ScalatraServlet with ScalateSupport {
  val logger = Logger(classOf[EnonceStoryServlet])

  post("/:id") {
    val id = params.getOrElse("id", -1)
    logger.info("id " + id)
    Created(id)
  }

  notFound {
    NotFound("I'm terribly sorry.")
  }

  before() {
    logger.info("> requestPath: " + requestPath)
    logger.info("> queryString: " + request.queryString)
    logger.info("> body: " + request.body)
    params.foreach(arg => logger.info("> param " + arg._1 + " -> " + arg._2))
    request.headers.foreach(arg => logger.info("> header " + arg._1 + " -> " + arg._2))
  }
}
