package algorithm.test.baekjoon.level02.exam07;

public class Main {
  public static void main(String[] args) {
    java.util.Scanner keyIn = new java.util.Scanner(System.in);
    int A = keyIn.nextInt(); // 1번주사위
    int B = keyIn.nextInt(); // 2번주사위
    int C = keyIn.nextInt(); // 3번주사위
    int D = A + B + C;
    if (A >= 1 && A <= 6 && B >= 1 && B <= 6 && C >= 1 && C <= 6)
      ;

    if (A == B && A == C && B == C) {
      System.out.println(D * 1000);
    } else if (A == B || A == C || B == C) {
      if (A == B) {
        System.out.println((A + B) * 100);
      } else if (A == C) {
        System.out.println((A + C) * 100);
      } else if (B == C) {
        System.out.println((B + C) * 100);
      }
    } else if (A != B && A != C && B != D) {

    }
  }
}
