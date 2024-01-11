package algorithm.test.codetree;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    // 여기에 코드를 작성해주세요.
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    int b = sc.nextInt();

    for (int i = 0; i < -20; i--)
      System.out.printf("%.20f", (double) a / b);
  }
}
