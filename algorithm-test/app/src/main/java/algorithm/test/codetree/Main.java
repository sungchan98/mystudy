package algorithm.test.codetree;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    // 여기에 코드를 작성해주세요.
    Scanner sc = new Scanner(System.in);
    String arr[] = new String[10];
    int arr2[] = new int[10];
    int cntArr[] = new int[10];

    for (int i = 0; i < 3; i++) {
      arr[i] = sc.next();
      arr2[i] = sc.nextInt();
    }

    for (int i = 0; i < 3; i++) {
      if (arr[i].equals("Y") && arr2[i] >= 37) {
        cntArr[0]++;
      }
      if (arr[i].equals("N") && arr2[i] >= 37) {
        cntArr[1]++;
      }
      if (arr[i].equals("Y") && arr2[i] < 37) {
        cntArr[2]++;
      }
      if (arr[i].equals("N") && arr2[i] < 37) {
        cntArr[3]++;
      }
    }
    for (int i = 0; i < 4; i++) {
      System.out.print(cntArr[i] + " ");
    }
    if (cntArr[0] >= 2) {
      System.out.print("E");
    }
  }
}
