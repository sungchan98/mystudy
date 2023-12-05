package com.eomcs.oop.ex02.step18;



import com.eomcs.oop.ex02.step18.vo.Score;
// 0) 클래스 사용전:낱개 변수 사용
// 1) 성적 데이터를 저장할 메모리를 새로 정의 :
// -'사용자 정의 데이터 타입(user-defined data type)'이라 부른다.
// - 여러 개로 이루어진 데이터를 한 묶음으로 다루면 관리하기가 쉽다

public class App {
  public static void main(String[] args) {

    // 1) Score 설계도(클레스 정의)에 따라 인스턴스 변수를 Heap 영역에 만든다.
    // 2) 생성자를 호출한다.
    // - 생성자에 넘겨주는 아규먼트의 타입과 개수, 순서에 따라 호출할 생성자를 결정한다.
    // - 만약 해당 아규먼트를 받을 수 있는 생성자가 없다면 컴파일 오류가 발생한다.
    Score s1 = new Score("홍길동", 100, 90, 85);;
    Score s2 = new Score("임꺽정", 90, 80, 75);
    Score s3 = new Score("유관순", 80, 70, 65);

    // s1.init("홍길동", 100, 90, 85);
    // s1.compute();

    // s2.init("임꺽정", 90, 80, 75);
    // s2.compute();

    // s3.init("유관순", 80, 70, 65);
    // s3.compute();

    // 변수의 값이 바뀌면
    s2.kor = 100;
    s2.compute();


    printScore(s1);
    printScore(s2);
    printScore(s3);

  }


  // pringScore()는 출력 기능만 담당하도록 변경
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
