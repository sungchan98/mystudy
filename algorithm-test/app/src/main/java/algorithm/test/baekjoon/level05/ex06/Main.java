package algorithm.test.baekjoon.level05.ex06;

import java.util.Scanner;

public class Main {
  public static void main(String args[]) {

    Scanner sc = new Scanner(System.in);

    String s = sc.nextLine();

    int arr[] = new int[26];

    for (int i = 0; i < 26; i++) {
      arr[i] = -1;
    }


    for (int i = 0; i < s.length(); i++) {
      int idx = s.charAt(i) - 'a';

      if (arr[idx] == -1) {
        arr[idx] = i;
      }
    }

    for (int i = 0; i < 26; i++) {
      System.out.print(arr[i] + " ");
    }
  }
}
