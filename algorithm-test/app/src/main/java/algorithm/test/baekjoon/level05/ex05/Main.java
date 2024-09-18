package algorithm.test.baekjoon.level05.ex05;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int sum = 0;
    String s = sc.next();

    for (int i = 0; i < n; i++) {
      // sum += Integer.parseInt(s, s.charAt(i));
      System.out.println(Integer.parseInt(s, s.charAt(i)));
    }

    System.out.println(sum);
  }
}
