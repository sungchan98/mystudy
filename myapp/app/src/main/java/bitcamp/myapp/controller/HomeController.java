package bitcamp.myapp.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

  private static final Log log = LogFactory.getLog(HomeController.class);

  @GetMapping("/home")
  public void home() { // url이 view 이름으로 사용됨
  }

//  @GetMapping("/home1")
//  public String home1() { // url이 view 이름으로 사용됨
//    return "home.jsp";
//  }
//
//  @GetMapping("/home2")
//  public String home2() { // url이 view 이름으로 사용됨
//    return "home.html";
//  }

}
