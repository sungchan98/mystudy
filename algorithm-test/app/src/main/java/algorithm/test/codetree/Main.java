package algorithm.test.codetree;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();

    // int[][] arr2d = new int[n][m];

    for (int k = 0; k <= n + m; k++) {
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          System.out.printf("%d %d %d\n", k, i, j);
        }
      }
    }
  }
}

