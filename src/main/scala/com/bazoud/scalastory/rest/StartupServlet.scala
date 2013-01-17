package com.bazoud.scalastory.rest

import javax.servlet.http.HttpServlet
import org.squeryl.Session
import org.squeryl.SessionFactory
import org.squeryl.adapters.PostgreSqlAdapter
import com.bazoud.scalastory.domain.Schema
import org.squeryl.PrimitiveTypeMode._
import java.net.URI

/**
 * @author @obazoud (Olivier Bazoud)
 */
class StartupServlet extends HttpServlet {

  val db_driver = "org.postgresql.Driver"
  val db_uri = new URI(sys.env.getOrElse("DATABASE_URL", "postgresql://postgres:root@localhost:5432/scalastory"))
  val db_username = db_uri.getUserInfo().split(":").apply(0)
  val db_password = db_uri.getUserInfo().split(":").apply(1)
  val db_url = "jdbc:postgresql://" + db_uri.getHost() + ':' + db_uri.getPort() + db_uri.getPath()

  override def init() = {
    Class.forName(db_driver);
    System.out.println("db_uri: " + db_uri)
    System.out.println("db_username: " + db_username)
    System.out.println("db_password: xxx")
    System.out.println("db_url: " + db_url)
    SessionFactory.concreteFactory = Some(() =>
      Session.create(
        java.sql.DriverManager.getConnection(db_url, db_username, db_password),
        new PostgreSqlAdapter
      )
    )

//    try {
//      transaction {
//        Schema.printDdl(println(_))
//        // Schema.drop
//        Schema.create
//      }
//    } catch {
//      case e:Exception =>
//        e.printStackTrace()
//    }

    System.out.println("StartupServlet stared.")
  }

}
