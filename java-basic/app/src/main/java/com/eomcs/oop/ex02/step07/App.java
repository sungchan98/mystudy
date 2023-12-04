package com.eomcs.oop.ex02.step07;

import com.eomcs.oop.ex02.step07.util.Calculator;

// # 관련된 기능(메서드)을 묶어 분류하기
// 1) 분류 전
// 2) 메서드를 클래스로 묶어 분류하기
// 3) 클래스 변수 도입
// 4) 클래스 변수의 한계 확인
// 5) 인스턴스 변수 도입
// 6) 인스턴스 메서드 활용
// 7) 패키지 멤버 클래스로 분리
//
public class App {
  // Calculator 클래스를 향후 유지보수하기 쉽도록 별도의 파일로 분리한다.
  public static void main(String[] args) {

    // 다음 두 개의 식을 분리하여 계산해 보자!
    // - 연산자 우선 순위를 고려하지 않고 순서대로 계산하라!
    // 식1) 2 + 3 - 1 * 7 / 3 = ?
    // 식2) 3 * 2 + 7 / 4 - 5 = ?

    // 두 개의 식을 동시에 계산하고 싶은가?
    // 그럴려면 계산 결과를 개별적으로 관리할 수 있어야 한다.
    // 다음과 같이 각 식의 계산 결과를 보관할 메모리를 준비한다.

    // 다른 패키지의 클래스를 사용하려면 반드시 패키지명을 클래스 이름과 함께 지정해야 한다.
    // com.eomcs.oop.ex02.step07.util.Calculator c1 = new
    // com.eomcs.oop.ex02.step07.util.Calculator();
    // com.eomcs.oop.ex02.step07.util.Calculator c2 = new
    // com.eomcs.oop.ex02.step07.util.Calculator();

    Calculator c1 = new Calculator();
    Calculator c2 = new Calculator();

    // 계산을 수행할 대 계산 결과를 보관할 메모리를 메서드 호출 앞에서 전달하라!
    // - 인스턴스 메서드를 사용하면 파라미터로 인스턴스 주소를 전달할 필요가 없다
    c1.plus(2);
    c2.plus(3);// +3

    c1.plus(3);
    c2.multiple(2);// +3 *2

    c1.minus(1);
    c2.plus(7);// +3 * 2 + 7

    c1.multiple(7);
    c2.divide(4);// + 3 * 2 + 7 / 4

    c1.divide(3); // c1객체의 인스턴스(result변수)에 찾아가서 3을 곱해
    // result 변수가 어떤 인스턴스에 있는 변수인지 지정해야 한다.
    c2.minus(5);// + 3 * 2 + 7 / 4 - 5 = ?
    System.out.printf("result = %d\n", c1.result);


    // 각각의 계산식 결과는 서로 다른 result 변수에 보관되기 때문에
    // 새로 초기화시킬 필요가 없다.
    // c2.result =0;



    System.out.printf("result = %d\n", c2.result);
  }
}

