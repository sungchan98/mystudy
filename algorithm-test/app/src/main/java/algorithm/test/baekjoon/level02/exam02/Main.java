package algorithm.test.baekjoon.level02.exam02;

public class Main {
  public static void main(String[] args) {
    java.util.Scanner keyIn = new java.util.Scanner(System.in);
    int test = keyIn.nextInt();

    if (test > 100) {
      System.out.println("100점");
    } else if (test >= 90) {
      System.out.println("A");
    } else if (test >= 80) {
      System.out.println("B");
    } else if (test >= 70) {
      System.out.println("C");
    } else if (test >= 60) {
      System.out.println("D");
    } else {
      System.out.println("F");
    }
  }
}
