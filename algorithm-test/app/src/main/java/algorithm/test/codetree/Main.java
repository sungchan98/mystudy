package algorithm.test.codetree;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    // 여기에 코드를 작성해주세요.
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int x = 0;
    int a = 1;

    while (true) {
      x++;
      a *= 2;
      if (n == a) {
        break;
      }
    }
    System.out.println(x);
  }
}
