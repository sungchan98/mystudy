package algorithm.test.baekjoon.level03.ex10;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();

    for (int i = 0; i <= N; i++) {
      for (int j = 1; j <= i; j++) {
        System.out.print("\n");
      }
      System.out.print("*");
    }
  }
}
