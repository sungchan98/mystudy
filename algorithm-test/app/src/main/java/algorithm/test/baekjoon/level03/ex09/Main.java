package algorithm.test.baekjoon.level03.ex09;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();

    int sum = 0;

    for (int i = 1; i <= N; i++) {
      sum += sum;
      for (int j = 0; j < i; j++) {
        System.out.println("*");
      }
    }
  }
}
