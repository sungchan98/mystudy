package com.eomcs.oop.ex02.step13;

// 0) 클래스 사용전:낱개 변수 사용
// 1) 성적 데이터를 저장할 메모리를 새로 정의 :
// -'사용자 정의 데이터 타입(user-defined data type)'이라 부른다.
// - 여러 개로 이루어진 데이터를 한 묶음으로 다루면 관리하기가 쉽다

public class App {
  public static void main(String[] args) {


    Score s1 = new Score();
    Score s2 = new Score();
    Score s3 = new Score();


    s1.name = "홍길동";
    s1.kor = 100;
    s1.eng = 90;
    s1.math = 85;

    s2.name = "임꺽정";
    s2.kor = 90;
    s2.eng = 80;
    s2.math = 75;

    s3.name = "유관순";
    s3.kor = 80;
    s3.eng = 70;
    s3.math = 65;

    printScore(s1);
    printScore(s2);
    printScore(s3);

  }

  // 합계와 평균, 출력 코드를 분리하여 별도의 메서드로 정의한다.
  // 즉 중복 코드 제거하여 메서드로 정의해두면 재사용하기가 쉽다.
  //
  static void printScore(Score s) {
    s.sum = s.kor + s.eng + s.math;
    s.aver = (float) s.sum / 3;
    System.out.printf("%s: %d, %d, %d, %d, %.1f\n", s.name, s.kor, s.eng, s.math, s.sum, s.aver);
  }
}

// 클래스 문법의 용도?
// 1) 사용자 정의 데이터 타입 만들 때
// 즉 새로운 구조의 메모리를 설계할 때 사용한다.
// 2) 메서드를 묶을 때
// 서로 관련된 기능을 관리하기 쉽게 묶고 싶을 때 사용한다.
