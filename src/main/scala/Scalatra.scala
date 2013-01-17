import com.bazoud.scalastory._
import org.scalatra._
import javax.servlet.ServletContext
import rest.{EnonceStoryServlet, StartupServlet, ScalaStoryServlet}

/**
 * This is the Scalatra bootstrap file. You can use it to mount servlets or
 * filters. It's also a good place to put initialization code which needs to
 * run at application start (e.g. database configurations), and init params.
 */
class Scalatra extends LifeCycle {
  override def init(context: ServletContext) {
    println("Mount one or more servlets")
    context.addServlet("startup", classOf[StartupServlet]).setLoadOnStartup(5)
    context.mount(new EnonceStoryServlet, "/enonce/*")
    context.mount(new ScalaStoryServlet, "/*")
  }
}
