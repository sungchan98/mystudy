package algorithm.test.baekjoon.level01.exam10;

public class Main {
  public static void main(String[] args) {
    java.util.Scanner keyIn = new java.util.Scanner(System.in);
    int A = keyIn.nextInt();
    int B = keyIn.nextInt();

    int C = (B % 10) * A;
    int D = ((B % 100) / 10) * A;
    int E = (B / 100) * A;

    System.out.println(C);
    System.out.println(D);
    System.out.println(E);
    System.out.println(A * B);

  }
}
