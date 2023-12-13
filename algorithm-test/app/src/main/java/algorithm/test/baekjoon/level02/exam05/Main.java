package algorithm.test.baekjoon.level02.exam05;

public class Main {
  public static void main(String[] args) {
    java.util.Scanner keyIn = new java.util.Scanner(System.in);
    int H = keyIn.nextInt();
    int M = keyIn.nextInt();

    int a = H * 60;
    int b = (a + M) - 45;
    int c = b % 60; // 분
    int d = b / 60; // 시간

    if (M >= 45) {

    }

    System.out.println(d + " " + c);
  }
}
