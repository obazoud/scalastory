/*
 * Starts jetty for scalatra programatically
 *
 * Replace YourApplicationEndpointFilter with the filter in your application
 */

import com.bazoud.scalastory.rest.{EnonceStoryServlet, ScalaStoryServlet}
import grizzled.slf4j.Logger
import org.eclipse.jetty.server.Server
import org.eclipse.jetty.servlet.{DefaultServlet, ServletContextHandler}
import org.eclipse.jetty.webapp.WebAppContext

/**
 * @author @obazoud (Olivier Bazoud)
 */
object JettyLauncher {
  private val logger: Logger = Logger[this.type]

  def main(args: Array[String]) {
    logger.info("JettyLauncher...")
    val port = if(System.getenv("PORT") != null) System.getenv("PORT").toInt else 8080

    val server = new Server(port)
    val context = new WebAppContext()

    context setContextPath "/"
    context.setResourceBase("src/main/webapp")

    server.setHandler(context)

    server.start
    server.join

  }
}