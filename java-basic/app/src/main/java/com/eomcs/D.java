package com.eomcs;

public class D {
  public static void main(String[] args) {

    java.util.Scanner keyIn = new java.util.Scanner(System.in);
    int a = keyIn.nextInt();
    int b = keyIn.nextInt();

    if (a > b) {
      System.out.println(">");
    }
    if (a < b) {
      System.out.println("<");
    }
    if (a == b) {
      System.out.println("==");
    }

  }
}
