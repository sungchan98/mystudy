package algorithm.test.codetree;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    // 여기에 코드를 작성해주세요.
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    int b = sc.nextInt();

    int i = 0;
    int arr[] = new int[100];
    int cntArr[] = new int[100];
    int remain[] = new int[100];
    int sum = 0;

    while (true) {
      i++;
      if (a <= 1) {
        break;
      }
      arr[i] = a;
      remain[i] = a % b;
      if (arr[i] / b != 0) {
        cntArr[remain[i]]++;
      }
      a = a / b;
      sum = sum + (cntArr[remain[i]] * cntArr[remain[i]]);

      // System.out.print(remain[i] + " ");
      // System.out.println();
      // System.out.print(cntArr[i] + " ");
      System.out.print(cntArr[remain[i]] + " ");
    }

    System.out.print(sum);
  }
}
