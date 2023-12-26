package algorithm.test.baekjoon.level03.ex01;

public class Main {
  public static void main(String[] args) {
    java.util.Scanner keyIn = new java.util.Scanner(System.in);
    int N = keyIn.nextInt(); // 구구단 입력받음

    for (int i = 1; i <= 9; i++) {
      System.out.printf("%d * %d = %d\n", N, i, N * i);
    }
  }
}
