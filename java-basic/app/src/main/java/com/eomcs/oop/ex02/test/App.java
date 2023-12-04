package com.eomcs.oop.ex02.test;

// # 관련된 기능(메서드)을 묶어 분류하기
// 1) 분류 전
// 2) 메서드를 클래스로 묶어 분류하기
// 3) 클래스 변수 도입
// 4) 클래스 변수의 한계 확인
// 5) 인스턴스 변수 도입
// 6) 인스턴스 메서드 활용
// 7) 패키지 멤버 클래스로 분리
// Calculator 클래스를 향후 유지보수하기 쉽도록 별도의 패키지로 분류한다.
// - com.eomcs.oop.ex02.util 패키지를 만들어 분류한다.
// - import 를 이용하여 클래스의 패키지 정보를 지정한다.
public class App {

  public static void main(String[] args) {
    // 다음 식을 연산자 우선 순위를 고려하지 않고 순서대로 계산하라!
    // 2 + 3 - 1 * 7 / 3 = ?

    // 계산 결과를 담을 변수를 준비한다.
    // int result = 0;

    // 메서드를 호출하여 작업을 수행하고,
    // 리턴 결과는 로컬 변수에 저장한다.

    Calculator c1 = new Calculator();
    Calculator c2 = new Calculator();


    Calculator.plus(c1, 2);
    Calculator.plus(c2, 3); // + 3

    Calculator.plus(c1, 3);
    Calculator.multiple(c2, 2); // + 3 * 2

    Calculator.minus(c1, 1);
    Calculator.plus(c2, 7); // + 3 * 2 + 7

    Calculator.multiple(c1, 7);
    Calculator.divide(c2, 4); // + 3 * 2 + 7 / 4

    Calculator.divide(c1, 3);
    Calculator.minus(c2, 5); // + 3 * 2 + 7 / 4 - 5 = ?


    System.out.printf("result = %d\n", c1.result);

    System.out.printf("result = %d\n", c2.result);
  }

}
// 클래스 문법의 용도?
// 1) 사용자 정의 데이터 타입 만들 때
// - 즉 새로운 구조의 메모리를 설계할 때 사용한다.
// 2) 메서드를 묶을 때
// - 서로 관련된 기능을 관리하기 쉽게 묶고 싶을 때 사용한다.


