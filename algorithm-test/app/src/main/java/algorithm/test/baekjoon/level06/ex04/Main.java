package algorithm.test.baekjoon.level06.ex04;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String str = sc.next();
    String str2 = "";

    for (int i = str.length() - 1; i >= 0; i--) {
      str2 += str.charAt(i);
    }

    if (str.equals(str2)) {
      System.out.print(1);
    } else {
      System.out.print(0);
    }

  }
}
