package algorithm.test.baekjoon.level04.ex01;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    // 여기에 코드를 작성해주세요.
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    int arr[] = new int[a];
    int cnt = 0;

    for (int i = 0; i < a; i++) {
      arr[i] = sc.nextInt();
    }

    int b = sc.nextInt();
    for (int i = 0; i < a; i++) {
      if (b == arr[i]) {
        cnt++;
      }
    }
    System.out.println(cnt);
  }
}
