/*
 * Starts jetty for scalatra programatically
 *
 * Replace YourApplicationEndpointFilter with the filter in your application
 */

import com.bazoud.scalastory.rest.{EnonceStoryServlet, StartupServlet, ScalaStoryServlet}
import org.eclipse.jetty.server.Server
import org.eclipse.jetty.servlet.{DefaultServlet, ServletContextHandler}
import org.eclipse.jetty.webapp.WebAppContext

/**
 * @author @obazoud (Olivier Bazoud)
 */
object JettyLauncher {
  def main(args: Array[String]) {
    println("JettyLauncher...")
    val port = if(System.getenv("PORT") != null) System.getenv("PORT").toInt else 8080

    val server = new Server(port)
    val context = new WebAppContext()

    context setContextPath "/"
    context.setResourceBase("src/main/webapp")
//    context.addServlet(classOf[StartupServlet], "").setInitOrder(5)
    context.addServlet(classOf[ScalaStoryServlet], "/*");
    context.addServlet(classOf[EnonceStoryServlet], "/enonce/*");
//    context.addServlet(classOf[DefaultServlet], "/")
    server.setHandler(context)

    server.start
    server.join

  }
}