package com.eomcs.reflect.ex06.a;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Exam0121 {
  public static void main(String[] args) {


    Class<?> aType = A.class; // A 인터페이스의 클래스 정보 = A 인터페이스의 타입 정보 = A인터페이스의 타입 = A의 타입
    Class<?> bType = B.class;
    Class<?> cType = C.class;

    Class<?>[] interfaceTypes = new Class<?>[] {aType, bType, cType};

    InvocationHandler invocationHandler = new InvocationHandler() {
      @Override
      public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("===> " + method.getName());
        return null;
      }
    };
    // newProxyInstance()가 리턴한 객체는
    // A, B, C 인터페이스를 모두 구현한 객체(클래스의 인스턴스)다
    Object obj = Proxy.newProxyInstance(Exam0121.class.getClassLoader(),
        new Class<?>[] {aType, bType, cType},

        (proxy, method, params) -> {
          System.out.println("===> " + method.getName());
          return null;
        });


    // obj.m1(); // 컴파일러는 번역할때 형식만 따지기 때문에 obj타입에는 m1,m2,m3가 없기 때문에 오류가 뜸
    ((A) obj).m1();
    ((B) obj).m2();
    ((C) obj).m3();

  }
}
