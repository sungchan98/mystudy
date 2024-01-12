package algorithm.test.codetree;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    // 여기에 코드를 작성해주세요.
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    int b = sc.nextInt();
    int i = 0;
    if (i <= b) {
      for (i = a; i <= b;) {
        if (i % 2 != 0) {
          i *= 2;
          System.out.print(i + " ");
        } else if (i % 2 == 0) {
          i += 3;
          System.out.print(i + " ");
        }
      }
    }
  }
}
