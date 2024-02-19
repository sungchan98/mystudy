package algorithm.test.baekjoon.level03.ex12;

import java.util.Scanner;

public class Main2 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int a = 0;
    int b = 0;
    while (sc.hasNext()) {
      a = sc.nextInt();
      b = sc.nextInt();
      System.out.printf("%d\n", a + b);

    }
  }
}

