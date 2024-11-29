package algorithm.test.baekjoon.level05.ex09;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String a = sc.next();
    String b = sc.next();

    String a1 = "";
    String b1 = "";

    for (int i = 2; i >= 0; i--) {
      a1 += a.charAt(i);
      b1 += b.charAt(i);
    }

    int numA = Integer.parseInt(a1);
    int numB = Integer.parseInt(b1);

    if (numA >= numB) {
      System.out.println(numA);
    } else {
      System.out.println(numB);
    }

  }
}
