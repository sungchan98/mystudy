package algorithm.test.baekjoon.level02.exam03;

public class Main {
  public static void main(String[] args) {
    java.util.Scanner keyIn = new java.util.Scanner(System.in);
    int year = keyIn.nextInt();
    boolean year1 = year % 4 == 0;
    boolean year2 = year % 100 != 0;
    boolean year3 = year % 400 == 0;
    if (year1 && year2) {
      System.out.println("1");
    } else if (year3) {
      System.out.println("1");
    } else {
      System.out.println("0");
    }
  }
}
