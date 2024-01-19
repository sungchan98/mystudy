package com.eomcs.reflect.ex06.a;

import java.lang.reflect.Proxy;

public class Exam0121 {
  public static void main(String[] args) {


    // newProxyInstance()가 리턴한 객체는
    // A, B, C 인터페이스를 모두 구현한 객체(클래스의 인스턴스)다
    Object obj = Proxy.newProxyInstance(Exam0121.class.getClassLoader(),
        new Class<?>[] {A.class, B.class, C.class}, (proxy, method, params) -> {
          System.out.println("===> " + method.getName());
          return null;
        });


    // obj.m1(); // 컴파일러는 번역할때 형식만 따지기 때문에 obj타입에는 m1,m2,m3가 없기 때문에 오류가 뜸
    ((A) obj).m1();
    ((B) obj).m2();
    ((C) obj).m3();

  }
}
