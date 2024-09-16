package algorithm.test.baekjoon.level05.ex04;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    String x = sc.next();

    if (x.charAt(0) >= 'A' && x.charAt(0) <= 'Z') {
      System.out.println((int) x.charAt(0));
    } else if (x.charAt(0) >= 'a' && x.charAt(0) <= 'z') {
      System.out.println((int) x.charAt(0));
    } else if (x.charAt(0) >= '0' && x.charAt(0) <= '9') {
      System.out.println((int) x.charAt(0));
    }
  }
}
