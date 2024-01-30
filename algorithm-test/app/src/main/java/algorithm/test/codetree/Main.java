package algorithm.test.codetree;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    // 여기에 코드를 작성해주세요.
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    for (int i = 0; i < n; i++) {
      for (int j = (n - i) * (n - i); j <= 1; j--) {
        // if (j == n - i) {
        // System.out.print(" ");
        // }
        System.out.print(j);
      }
      System.out.println();
    }
  }
}
