package com.bazoud.scalastory.rest

import org.scalatra._
import com.bazoud.scalastory.domain.Schema
import org.squeryl.PrimitiveTypeMode._
import com.bazoud.scalastory.domain.model.Enonce
import java.sql.Timestamp
import grizzled.slf4j.Logger
import org.scalatra
import scalate.ScalateSupport

class EnonceStoryServlet extends ScalatraServlet with ScalateSupport {
  val logger = Logger(classOf[EnonceStoryServlet])

  post("/:id") {
    try {
      transaction {
        val body = request.body
        println(body)
        val data:Enonce = Schema.enonce.insert( new Enonce( params("id").toLong , new Timestamp(System.currentTimeMillis), request.body )  )
        println("Data added : " + data)
        Created(data.id)
      }
    } catch {
      case e:NumberFormatException =>
        logger.error(e.getMessage, e)
        BadRequest("bad " + params("id"))
      case e:Exception =>
        logger.error(e.getMessage, e)
        InternalServerError("oops")
    }
  }

  get("/:id") {
    try {
      transaction {
        Schema.enonce.lookup(params("id").toLong) match {
          case None          => NotFound("can not found " + params("id"))
          case Some(enonce)  => Ok("{ \"id\": " + enonce.id + ", \"content\": \"" + enonce.content + "\" }")
        }
      }
    } catch {
      case e:Exception =>
        logger.error(e.getMessage, e)
        InternalServerError("oops")
    }
  }

  notFound {
    NotFound("I'm terribly sorry, but we have a 404 not found problem here!")
  }

}
