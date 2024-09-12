package algorithm.test.baekjoon.level04.ex09;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();

    int arr[] = new int[n + 1];

    // 배열 생성
    for (int i = 1; i <= n; i++) {
      arr[i] = i;
    }

    for (int i = 0; i < m; i++) {
      int a = sc.nextInt();
      int b = sc.nextInt();

      for (int j = a; j <= b; j++) {
        arr[j] = n - j - 1;
        // System.out.print(arr[i] + " ");
      }
    }

    // 출력
    for (int i = 1; i <= n; i++) {
      System.out.print(arr[i] + " ");
    }
  }
}
