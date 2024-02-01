package algorithm.test.codetree;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    // 여기에 코드를 작성해주세요.

    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int cnt = n;

    for (int i = n; i > 0; i--) {
      for (int j = 1; j <= i * i; j++) {

        System.out.print("*");
        if (j % i == 0) {
          System.out.print(" ");
        }
      }
      System.out.println();
    }
  }
}
