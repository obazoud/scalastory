package com.bazoud.scalastory.domain.model

import java.sql.Timestamp
import org.squeryl.KeyedEntity
import org.squeryl.annotations._

/**
 * @author @obazoud (Olivier Bazoud)
 */
class Enonce(
    @Column("id")
    val id:Long,
    @Column("lastModified")
    val lastModified:Timestamp,
    @Column("content")
    val content:String
  ) extends KeyedEntity[Long] {

  def this() = this(0, new Timestamp(System.currentTimeMillis), null)

}
