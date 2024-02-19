package algorithm.test.baekjoon.level03.ex12;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);


    while (true) {
      int A = sc.nextInt();
      if (!(A > 0)) {
        break;
      }
      int B = sc.nextInt();
      if (!(B > 0)) {
        break;
      }
      String str = sc.next();
      if (str.equalsIgnoreCase("exit")) {
        break;
      }
      System.out.println(A + B);
    }
  }
}
