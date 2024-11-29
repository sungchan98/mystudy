package algorithm.test.baekjoon.level05.ex07;

import java.util.Scanner;

public class Main {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();

    for (int i = 0; i < t; i++) {
      int n = sc.nextInt();
      String s = sc.next();

      String p = "";

      for (int j = 0; j < s.length(); j++) {
        for (int k = 0; k < n; k++) {
          p += s.charAt(j);
        }
      }
      System.out.println(p);
    }
  }
}
