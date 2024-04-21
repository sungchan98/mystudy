package algorithm.test.codetree;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    // 여기에 코드를 작성해주세요.
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int arr[] = new int[n];
    int a = 0;
    final int INT_MAX = Integer.MAX_VALUE;
    int minVal = INT_MAX;

    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }

    for (int i = n - 1; i > 0; i--) {

      for (int j = i - 1; j >= 0; j--) {
        if (arr[i] - arr[j] < minVal) {
          minVal = arr[i] - arr[j];
        }
      }
    }
    System.out.println(minVal);
  }
}
