package algorithm.test.baekjoon.level02.exam06;

public class Main {
  public static void main(String[] args) {
    java.util.Scanner keyIn = new java.util.Scanner(System.in);
    int A = keyIn.nextInt(); // 시
    int B = keyIn.nextInt(); // 분
    int C = keyIn.nextInt(); // 필요한 시간

    int T = (A * 60) + B + C; // 총시간

    int i = T / 60; // 필요한 시간 시
    int j = T % 60; // 필요한 시간 분

    if (A >= 0 && A <= 23 && B >= 0 && B <= 59 && C >= 0 && C <= 1000)
      ;

    if (j == 60) {
      j = 0;
      i += 1;
    }

    if (i == 24) {
      i = 0;
    } else if (i > 24) {
      i = i - 24;
    }

    System.out.println(i + " " + j);
  }
}


