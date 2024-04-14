package algorithm.test.baekjoon.level04.ex02;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    int b = sc.nextInt();
    int arr[] = new int[a];
    int arr2[] = new int[a];
    int cnt = 0;
    for (int i = 0; i < a; i++) {
      arr[i] = sc.nextInt();
      if (arr[i] < b) {
        cnt++;
      }
    }

    for (int i = 0; i < cnt; i++) {
      if (arr[i] < b) {
        arr2[i] = arr[i];
      }
      System.out.printf(arr2[i] + " ");
    }
  }
}
