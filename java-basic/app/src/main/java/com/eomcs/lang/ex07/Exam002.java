package com.eomcs.lang.ex07;



public class Exam002 {
  public static void main(String[] args) {
    java.util.Scanner keyScan = new java.util.Scanner(System.in);
    int a = keyScan.nextInt();
    int b = keyScan.nextInt();

    System.out.println(a + b);

    System.out.println(a - b);

    System.out.println(a * b);

    System.out.println((float) a / (float) b);

    System.out.println(a % b);
  }
}
