package bitcamp.myapp.servlet;

import java.lang.reflect.Method;

public class RequestHandler { // 요청을 다루는 자

  Object controller;
  Method handler;

  public RequestHandler() {

  }

  public RequestHandler(Object controller, Method handler) {
    this.handler = handler;
    this.controller = controller;
  }
}
