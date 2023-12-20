package algorithm.test.baekjoon.level02.exam05;

public class Main {
  public static void main(String[] args) {
    java.util.Scanner keyIn = new java.util.Scanner(System.in);
    int H = keyIn.nextInt();
    int M = keyIn.nextInt();

    int a = H * 60; // 시간을 분으로 바꿈
    int b = (a + M) - 45; // 분으로 합친거에서 45분을 뺏음
    int c = b % 60; // 분
    int d = b / 60; // 시간

    if (b < 0) {
      c += 60;
      d = 23;
      if (c == 60) {
        d += 1;
        c = 0;
      }
      if (d == 24)
        d = 0;
    }
    System.out.println(d + " " + c);
  }
}
