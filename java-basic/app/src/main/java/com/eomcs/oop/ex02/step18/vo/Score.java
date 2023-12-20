package com.eomcs.oop.ex02.step18.vo;

// ## 사용자 정의 데이터 타입 만들기
// -특정 유형의 데이터를 담을 전용 메모리(변수)를 설계한다.
// - 학생 데이터를 묶음으로 다룰 수 있도록 변수 그룹을 정의한다.
// 2) 리팩토링:
// -메서드 추출(extract method)
// -
public class Score {
  // 인스턴스 변수(instance variable; instance field)
  // - new 명령으로 생성되는 변수이다.
  // - 성적 데이터를 개별적으로 다루고 싶을 때 인스턴스 변수로 선언한다.
  //
  public String name;
  public int kor;
  public int eng;
  public int math;
  public int sum;
  public float aver;

  // 클래스에 생성자가 없으면, 컴파일러는 파라미터가 없는 기본 생성자를 자동 추가한다.
  // public Score(){
  // }

  // 생성자
  public Score(String name, int kor, int eng, int math) {
    this.name = name;
    this.kor = kor;
    this.eng = eng;
    this.math = math;

    this.compute();
  }

  public void compute() {
    this.sum = this.kor + this.eng + this.math;
    this.aver = (float) this.sum / 3;
  }
}