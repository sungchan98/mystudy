package com.eomcs.web.ex12;


import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRegistration.Dynamic;
import javax.servlet.annotation.WebListener;

@WebListener
public class Listener01 implements ServletContextListener {

  @Override
  public void contextInitialized(ServletContextEvent sce) {
    // 프로그램 적으로 배치하는 방법(프로그래머틱) , 동적으로 서블릿을 배치 시킨다.
    ServletContext sc = sce.getServletContext();

    Servlet03 s = new Servlet03();
    Dynamic 서블릿설정정보 =  sc.addServlet("ex12.Servlet03", s); // <servlet>...</servlet>
    서블릿설정정보.addMapping("/ex12/s03"); // <servlet-mapping>...</servlet-mapping>
  }
}
