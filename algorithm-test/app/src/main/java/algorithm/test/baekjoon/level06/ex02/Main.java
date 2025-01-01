package algorithm.test.baekjoon.level06.ex02;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int arr[] = new int[6];
    int wPice[] = new int[6];

    for (int pice : wPice) {
      wPice[0] = 1;
      wPice[1] = 1;
      wPice[2] = 2;
      wPice[3] = 2;
      wPice[4] = 2;
      wPice[5] = 8;
    }

    for (int i = 0; i < 6; i++) {
      arr[i] = sc.nextInt();
    }

    for (int i = 0; i < 6; i++) {
      System.out.print(wPice[i] - arr[i] + " ");
    }
  }
}
