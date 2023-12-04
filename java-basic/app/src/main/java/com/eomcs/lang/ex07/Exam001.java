package com.eomcs.lang.ex07;

import java.util.Scanner;

// 1단계: 공백 출력 코드를 메서드로 추출하기
//
public class Exam001 {


  static void printSpaces(int spaceLen) {
    // 별 앞에 공백 출력
    int spaceCnt = 1;
    while (spaceCnt <= spaceLen) {
      System.out.print(" ");
      spaceCnt++;
    }
  }

  static void printStars(int starLen) {
    // 별 출력
    int starCnt = 1;
    while (starCnt <= starLen) {
      System.out.println("*");
      starCnt++;
    }
  }

  static int computeSpaceLength(int len, int starLen) {
    return (len - starLen) / 2;
  }

  static int promptInt(String title) {
    Scanner keyScan = new Scanner(System.in);
    System.out.print(title);
    int len = keyScan.nextInt();
    keyScan.close();


    return len;
  }

  public static void main(String[] args) {
    int len = promptInt("밑변의 길의");
    for (int starLen = 1; starLen <= len; starLen += 2) {
      printSpaces(computeSpaceLength(len, starLen));


      printStars(starLen);


    }
  }
}
