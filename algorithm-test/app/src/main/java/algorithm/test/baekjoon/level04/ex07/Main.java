package algorithm.test.baekjoon.level04.ex07;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int arr[] = new int[31];

    for (int i = 1; i <= 30; i++) {
      arr[i] = i;
    }

    for (int i = 0; i < 28; i++) {
      int n = sc.nextInt();
      arr[n] = 0;
    }


    for (int i = 1; i <= 30; i++) {
      if (arr[i] != 0) {
        System.out.println(arr[i]);
      }
    }
  }
}
