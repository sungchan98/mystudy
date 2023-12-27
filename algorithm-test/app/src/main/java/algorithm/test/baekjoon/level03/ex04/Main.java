package algorithm.test.baekjoon.level03.ex04;

public class Main {
  public static void main(String[] args) {
    java.util.Scanner keyIn = new java.util.Scanner(System.in);
    long X = keyIn.nextLong();
    int N = keyIn.nextInt();
    long a = 0;
    int b = 0;
    long sum = 0;

    for (int i = 0; i < N; i++) {
      a = keyIn.nextLong();
      b = keyIn.nextInt();
      sum += a * b;
      // System.out.println(sum);
    }

    if (X == sum) {
      System.out.println("Yes");
    } else if (X != sum)
      System.out.println("No");
  }
}
