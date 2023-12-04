package com.eomcs.oop.ex02.step05;


public class Calculator {

  // 인스턴스 변수(= non-static 변수)
  // - 작업 결과를 개별적으로 관리하고 싶을 때 인스턴스 변수로 선언한다.
  // - 인스턴스 변수는 클래스가 로딩 될 때 만들어지지 않는다.
  // - new 명령을 사용해서 만들어야 한다.
  // - 변수 선언 앞에 static이 붙지 않는다.
  int result = 0;
  // 클래스를 만들때는 static을 붙이거나 안붙이거나
  //

  // 메서드 작업 결과는 인스턴스 변수에 보관한다.
  // 그러기 위해 메서드가 ㅎ출될 때 인스턴스 주소를 받아야 한다..
  static void plus(Calculator instance, int value) {
    // result = result + value;
    instance.result += value;
  }

  static void minus(Calculator instance, int value) {
    instance.result -= value;
  }

  static void multiple(Calculator instance, int value) {
    instance.result *= value;
  }

  static void divide(Calculator instance, int value) {
    instance.result /= value;
  }

  // 다음 메서드는 result 변수를 사용하지 않기 때문에
  // Calculator의 인스턴스 주소를 받을 필요가 없다.
  static int abs(int a) {
    //
    // if (a >= 0)
    // return a;
    // else
    // return a * -1;
    //

    // 다음 메서드는 계산 결과를 사용하지 않는다.
    // 파라미터 값에 대해 절대값을 리턴하는 일을 한다.
    return a >= 0 ? a : a * -1;
  }
}
