package algorithm.test.baekjoon.level03.ex02;

public class Main {
  public static void main(String[] args) {
    java.util.Scanner keyIn = new java.util.Scanner(System.in);
    int T = keyIn.nextInt();
    int A = 0;
    int B = 0;
    for (int i = 0; i < T; i++) {
      A = keyIn.nextInt();
      B = keyIn.nextInt();
    }
    for (int j = 0; j < T; j++) {
      System.out.println(A + B);
    }
  }
}
