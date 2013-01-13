/*
 * Starts jetty for scalatra programatically
 *
 * Replace YourApplicationEndpointFilter with the filter in your application
 */

import com.bazoud.scalastory.ScalaStoryServlet
import org.eclipse.jetty.server.Server
import org.eclipse.jetty.servlet.{DefaultServlet, ServletContextHandler}

/**
 * @author @obazoud (Olivier Bazoud)
 */
object JettyLauncher {
  def main(args: Array[String]) {
    val port = if(System.getenv("PORT") != null) System.getenv("PORT").toInt else 8080

    val server = new Server(port)
    val context = new ServletContextHandler(server, "/", ServletContextHandler.SESSIONS)

    context.addServlet(classOf[ScalaStoryServlet], "/");
    context.setResourceBase("src/main/webapp")

    try {
      server.start
      server.join
    } catch {
      case e: Exception => {
        e.printStackTrace()
        System.exit(1)
      }
    }
  }
}