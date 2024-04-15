package algorithm.test.baekjoon.level04.ex03;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    int arr[] = new int[a];

    final int INT_MAX = Integer.MAX_VALUE;
    final int INT_MIN = Integer.MIN_VALUE;

    int maxVal = INT_MIN;
    int minVal = INT_MAX;

    for (int i = 0; i < a; i++) {
      arr[i] = sc.nextInt();
      if (minVal > arr[i]) {
        minVal = arr[i];
      }
      if (maxVal < arr[i]) {
        maxVal = arr[i];
      }
    }
    System.out.printf(minVal + " " + maxVal);
  }
}
