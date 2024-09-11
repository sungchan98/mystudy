package algorithm.test.baekjoon.level04.ex08;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    int arr[] = new int[11];

    int cnt = 0;

    for (int i = 0; i < 10; i++) {
      int n = sc.nextInt();
      arr[i] = n % 42;
    }

    for (int i = 0; i < 10; i++) {
      int j;
      for (j = 0; j < i; j++) {

        if (arr[i] == arr[j]) {
          break;
        }
      }

      if (j == i) {
        cnt++;
      }
    }


    System.out.println(cnt);

  }
}
