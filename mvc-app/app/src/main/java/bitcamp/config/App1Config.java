package bitcamp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;

@ComponentScan("bitcamp.app1")
public class App1Config {

  @Bean
  MultipartResolver multipartResolver(){
    StandardServletMultipartResolver mr = new StandardServletMultipartResolver(); // 스프링에 있는 프론트컨트롤러를 위한 것
    return mr;
  }
}
