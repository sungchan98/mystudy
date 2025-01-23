package algorithm.test.baekjoon.level05.ex10;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    String[] dial = {"ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"};

    Scanner sc = new Scanner(System.in);
    String word = sc.nextLine();
    sc.close();

    int totalTime = 0;

    for (int i = 0; i < word.length(); i++) {
      char a = word.charAt(i);
      for (int j = 0; j < dial.length; j++) {
        if (dial[j].indexOf(a) != -1) {
          totalTime += j + 3;
          break;
        }
      }
    }

    System.out.println(totalTime);

  }
}
