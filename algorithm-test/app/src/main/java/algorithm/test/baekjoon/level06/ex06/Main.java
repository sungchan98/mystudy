package algorithm.test.baekjoon.level06.ex06;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    String[] croatia = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

    Scanner sc = new Scanner(System.in);

    String str = sc.next();

    for (int i = 0; i < croatia.length; i++) {
      str = str.replace(croatia[i], "*");
    }

    System.out.println(str.length());
  }
}
