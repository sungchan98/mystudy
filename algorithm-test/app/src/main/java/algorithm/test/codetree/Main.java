package algorithm.test.codetree;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    // 여기에 코드를 작성해주세요.
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    boolean satisfied = false;

    for (int i = 1; i <= n; i++) {
      if (n % i == 0 && n / i == 1) {
        satisfied = true;
      }
    }

    if (satisfied == true) {
      System.out.println("N");
    } else if (satisfied == false) {
      System.out.println("C");
    }
  }
}
