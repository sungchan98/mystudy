package algorithm.test.codetree;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    // 여기에 코드를 작성해주세요.
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    int b = sc.nextInt();

    int sumVal = 0;
    int sumVal2 = 0;
    if (a <= b) {
      for (int i = a; i <= b; i++) {
        if (i % 5 == 0) {
          sumVal += i;
        }
      }
      System.out.println(sumVal);
    }
    if (a >= b) {
      for (int i = a; i >= b; i--) {
        if (i % 5 == 0) {
          sumVal2 += i;
        }
      }
      System.out.println(sumVal2);
    }
  }
}
