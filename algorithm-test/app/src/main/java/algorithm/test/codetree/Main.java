package algorithm.test.codetree;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    // 여기에 코드를 작성해주세요.
    Scanner sc = new Scanner(System.in);
    int arr[] = new int[100];
    final int INT_MAX = Integer.MAX_VALUE;
    final int INT_MIN = Integer.MIN_VALUE;

    int maxVal = INT_MIN;
    int minVal = INT_MAX;

    for (int i = 0; i < 100; i++) {
      arr[i] = sc.nextInt();
      if (arr[i] == 999 || arr[i] == -999) {
        break;
      }
      if (minVal > arr[i]) {
        minVal = arr[i];
      }
      if (maxVal < arr[i]) {
        maxVal = arr[i];
      }
    }
    System.out.printf(maxVal + " " + minVal);
  }
}
