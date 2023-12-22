package algorithm.test.baekjoon.level02.exam07;

public class Main {
  public static void main(String[] args) {
    java.util.Scanner keyIn = new java.util.Scanner(System.in);
    int A = keyIn.nextInt(); // 1번주사위
    int B = keyIn.nextInt(); // 2번주사위
    int C = keyIn.nextInt(); // 3번주사위

    if (A >= 1 && A <= 6 && B >= 1 && B <= 6 && C >= 1 && C <= 6)
      ;

    if (A == B && A == C && B == C) {
      System.out.println((A * 1000) + 10000);
    } else if (A == B || A == C || B == C) {
      if (A == B) {
        System.out.println((100 * A) + 1000);
      } else if (A == C) {
        System.out.println((100 * A) + 1000);
      } else if (B == C) {
        System.out.println((100 * B) + 1000);
      }
    } else if (A != B && A != C && B != C) {
      if (A > B && A > C) {
        System.out.println(A * 100);
      } else if (B > A && B > C) {
        System.out.println(B * 100);
      } else if (C > A && C > B) {
        System.out.println(C * 100);
      }
    }
  }
}
