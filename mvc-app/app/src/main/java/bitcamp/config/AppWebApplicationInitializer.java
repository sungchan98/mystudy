package bitcamp.config;

import javax.servlet.Registration.Dynamic;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;

public class AppWebApplicationInitializer extends AbstractDispatcherServletInitializer {

  private  static Log log = LogFactory.getLog(AppWebApplicationInitializer.class);
  AnnotationConfigWebApplicationContext rootContext;

  @Override
  protected WebApplicationContext createRootApplicationContext() {
    return null;
  }

  @Override
  protected WebApplicationContext createServletApplicationContext() {
    AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
    appContext.register(AppConfig.class);
    appContext.refresh();
    return appContext;
  }

  @Override
  protected String[] getServletMappings() {
    return new String[]{"/app/*"};
  }

  @Override
  protected String getServletName() {
    return "app";
  }

}
