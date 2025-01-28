package algorithm.test.baekjoon.level07.ex02;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int arr[][] = new int[9][9];

    int maxVal = 0;
    int low = 0;
    int column = 0;

    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        arr[i][j] = sc.nextInt();
      }
    }

    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        if (arr[i][j] > maxVal) {
          maxVal = arr[i][j];
          low = i;
          column = j;
        }
      }
    }

    System.out.println(maxVal);
    System.out.print((low + 1) + " " + (column + 1));

  }
}
