package com.eomcs.oop.ex02.step07.util;


public class Calculator {

  // 다른 패키지에서 이 클래스와 멤버(필드 및 메서드)를 접근할 수 있도록
  // public 으로 공개한다.

  public int result = 0;


  public void plus(int value) {
    // 인스턴스 메서드
    // -메서드를 호출할 때 앞에서 전달한 인스턴스 주소를 받을 수 있도록
    // this 라는 이름의 내장 변수에 자동 저장된다.
    this.result += value;
  }

  public void minus(int value) {
    this.result -= value;
  }

  public void multiple(int value) {
    this.result *= value;
  }

  public void divide(int value) {
    this.result /= value;
  }

  // 다음 메서드는 result 변수를 사용하지 않기 때문에
  // Calculator의 인스턴스 주소를 받을 필요가 없다.
  public static int abs(int a) {
    // 스테틱 메서드는 this라는 내장 변수가 없다.
    return a >= 0 ? a : a * -1;
  }
}
