package com.bazoud.scalastory.domain

import org.squeryl._
import org.squeryl.PrimitiveTypeMode._
import com.bazoud.scalastory.domain.model._

/**
 * @author @obazoud (Olivier Bazoud)
 */
object Schema extends Schema {
  val enonce = table[Enonce]

  on(enonce)(e => declare(
    e.id is(primaryKey),
    e.content is(dbType("text"))
  ))
}
