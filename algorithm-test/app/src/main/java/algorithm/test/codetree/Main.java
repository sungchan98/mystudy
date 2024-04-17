package algorithm.test.codetree;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    // 여기에 코드를 작성해주세요.
    Scanner sc = new Scanner(System.in);

    int a = sc.nextInt();
    int b = sc.nextInt();
    int idx = -1;
    boolean c = true;

    int arrA[] = new int[100];
    int arrB[] = new int[100];

    for (int i = 0; i < a; i++) {
      arrA[i] = sc.nextInt();
    }

    for (int i = 0; i < b; i++) {
      arrB[i] = sc.nextInt();
    }

    for (int i = 0; i < a; i++) {
      if (arrA[i] != arrB[i]) {
        idx = i + 1;
        if (arrA[idx] == arrB[i]) {

        }
      }
    }

    if (idx == -1) {
      System.out.print("No");
    } else {
      System.out.print("Yes");
    }
  }
}
