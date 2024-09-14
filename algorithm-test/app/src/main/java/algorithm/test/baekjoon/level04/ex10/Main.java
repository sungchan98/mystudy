package algorithm.test.baekjoon.level04.ex10;

import java.util.Scanner;

public class Main {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    int grade[] = new int[n];
    int M = 0;

    // 입력
    for (int i = 0; i < n; i++) {
      grade[i] = sc.nextInt();
    }

    // 최댓값 구하기
    for (int i = 0; i < n; i++) {
      if (grade[i] >= M) {
        M = grade[i];

      }
    }
    double[] newGrade = new double[n];
    for (int i = 0; i < n; i++) {

      newGrade[i] = (double) grade[i] / M * 100;

    }

    double mean = 0;

    for (int i = 0; i < n; i++) {
      mean += newGrade[i];
    }

    System.out.print(mean / n);

  }
}

