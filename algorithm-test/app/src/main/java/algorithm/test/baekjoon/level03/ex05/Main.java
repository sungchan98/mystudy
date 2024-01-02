package algorithm.test.baekjoon.level03.ex05;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner keyIn = new Scanner(System.in);
    int N = keyIn.nextInt();
    int count = N / 4;
    for (int i = 0; i < count; i++) {
      System.out.print("long ");
    }
    System.out.print("int");
  }
}
