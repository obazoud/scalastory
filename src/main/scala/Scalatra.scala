import com.bazoud.scalastory._
import grizzled.slf4j.Logger
import org.scalatra._
import javax.servlet.ServletContext
import rest.{EnonceStoryServlet, ScalaStoryServlet}

/**
 * This is the Scalatra bootstrap file. You can use it to mount servlets or
 * filters. It's also a good place to put initialization code which needs to
 * run at application start (e.g. database configurations), and init params.
 */
class Scalatra extends LifeCycle {
  private val logger: Logger = Logger[this.type]

  override def init(context: ServletContext) {
    logger.info("Mounting servlets")
    context.mount(new EnonceStoryServlet, "/enonce/*")
    context.mount(new ScalaStoryServlet, "/*")
  }

  override def destroy(context: ServletContext) {
    super.destroy(context)
  }
}
