package algorithm.test.baekjoon.level04.ex04;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    int arr[] = new int[9];
    final int INT_MIN = Integer.MIN_VALUE;
    int maxVal = INT_MIN;
    int cnt = 0;

    for (int i = 0; i < 9; i++) {
      arr[i] = sc.nextInt();
      if (maxVal < arr[i]) {
        maxVal = arr[i];
      }
    }

    for (int i = 0; i < 9; i++) {
      cnt++;
      if (arr[i] == maxVal) {
        break;
      }
    }


    System.out.println(maxVal);
    System.out.println(cnt);
  }
}
