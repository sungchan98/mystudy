// 메서드 레퍼런스 - 활용예
package com.eomcs.oop.ex12;

import java.util.function.Predicate;

public class Exam0633 {

  public static void main(String[] args) {

    // Predicate<String> 인터페이스 구현체 준비하기

    // 4) 메서드 레퍼런스를 사용하여 기존 클래스의 메서드를 인터페이스 구현체로 사용하기
    // String s1 = "";
    // Predicate<String> p4 = s1::isEmpty; // 컴파일 오류
    // => Predicate<String> p4 = (String value) -> {return s1.isEmpty(value)};

    String s2 = "Hello!";


    // => 의미: "Predicate 인터페이스 구현체로서 String의 isEmpty()를 사용하겠다"
    Predicate<String> p4 = String::isEmpty; // OK?

    // 이전의 방식으로 생각하면 위 코드는 다음의 코드로 변경 되어야 한다.
    // => Predicate<String> p4 = (String value) -> { return String.isEmpty(value);};
    // 위 코드는 컴파일 오류가 발생해야 한다.

    // 이유:
    // 1) isEmpty() 메서드는 스태틱 매서드가 아니기 때문에 스태틱 메서드 처럼 호출하면 오류가 발생해야 한다.
    // 2) isEmpty() 는 파라미터가 없기 때문에 String 값을 받을 수 없다..
    // 그러나, 컴파일 오류가 발생하지 않는다.

    // 인터페이스의 타입 파라미터에 전달하는 클래스와 메서드 레퍼런스로 전달하는 클래스가 같을 때
    // 위 코드는 다음과 같이 변경된다.
    // => Predicate<String> p4 = (String value) -> { return value.isEmpty();};
    System.out.println(p4.test("")); // true
    System.out.println(p4.test("Hello!")); // false

  }

}


