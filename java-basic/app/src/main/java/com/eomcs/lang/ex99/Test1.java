package com.eomcs.lang.ex99;



public class Test1 {
  public static void main(String[] args) throws Exception {
    java.io.InputStream in = System.in;// import java.io.InputStream
    java.util.Scanner keyIn = new java.util.Scanner(in); // import java.util.Scanner,스케너에 담아서 쓰게되면
    // 스케너에 있는 것을 사용할 수 있게 됨
    String str = keyIn.nextLine();// nextLine안에 바이트로 읽어서 유니코드로 바꿔서 문자열로 바꾸는 것이 담겨 있음
    // nextLine()을 쓰려면 Scanner를 사용 해야함.

    // int b = in.read() //byte를 리턴하는데 int로 리턴함

    // keyIn.nextLine() ->keyIn(scanner 객체,keyIn 변수애 scanner 정보가 들어 있는 것은 아니지만 정보가 들어 있는
    // 변수로 간주하여 표현한다 =>why? -> 의사소통을 단순하게 하기위해, 이해를 쉽게 하기위해
    System.out.println("==> " + str);
    keyIn.close();// 잠구는거,잠구는 것을 습관화 할것
  }
}
