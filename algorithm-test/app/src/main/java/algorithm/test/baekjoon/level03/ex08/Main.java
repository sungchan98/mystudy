package algorithm.test.baekjoon.level03.ex08;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int T = sc.nextInt();

    for (int i = 1; i <= T; i++) {
      int A = sc.nextInt();
      int B = sc.nextInt();
      System.out.printf("Case #%d: %d + %d = %d\n", i, A, B, A + B);
    }
  }
}

