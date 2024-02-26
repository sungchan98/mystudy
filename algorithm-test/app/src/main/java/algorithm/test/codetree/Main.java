package algorithm.test.codetree;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    // 여기에 코드를 작성해주세요.
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    for (int i = 1; i <= n; i++) {
      for (int j = n; j >= i; j--) {

        System.out.printf("%d * %d = %d ", i, n - j + 1, i * (n - j + 1));
        if (j != i) {
          System.out.print("/ ");
        }

      }
      System.out.println();
    }
  }
}
