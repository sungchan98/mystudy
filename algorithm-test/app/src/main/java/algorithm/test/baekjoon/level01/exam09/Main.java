package algorithm.test.baekjoon.level01.exam09;

public class Main {
  public static void main(String[] args) {
    java.util.Scanner keyIn = new java.util.Scanner(System.in);
    int A = keyIn.nextInt();
    int B = keyIn.nextInt();
    int C = keyIn.nextInt();

    System.out.println((A + B) % C);
    System.out.println(((A % C) + (B % C)) % C);
    System.out.println((A * B) % C);
    System.out.println(((A % C) * (B % C)) % C);


  }
}
