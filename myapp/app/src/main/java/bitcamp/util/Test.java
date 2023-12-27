package bitcamp.util;

public class Test {

  public static void main(String[] args) {
    LinkedList list = new LinkedList();
    list.add("aaa");
    list.add("bbb");
    list.add("ccc");
    list.add("ddd");

    System.out.println(list.remove("xxx"));//aaa,bbb,ccc,ddd
    System.out.println(list.remove("ccc"));//aaa,bbb,ddd
    System.out.println(list.remove("ddd"));//aaa,bbb
    System.out.println(list.remove("aaa"));//bbb
    System.out.println(list.remove("bbb"));//

    list.add("xxx");//xxx
    list.add("yyy");//xxx,yyy
    list.add("zzz");//xxx,yyy,zzz

//    list.remove(2); //aaa,bbb,ddd
//    list.remove(2); //aaa,bbb
//    list.remove(0); //bbb
//    list.remove(0);

    //    // 맨 앞
//    list.add(0, new String("xxx"));
//    // 맨 뒤
//    list.add(5, new String("yyy"));
//    // 기존 값 자리
//    list.add(1, new String("mmm"));
//    list.add(3, new String("ttt"));
//    list.add(7, new String("ppp"));

    Object[] arr = list.toArray();
    for (Object value : arr) {
      System.out.printf("%s, ", value);
    }
    System.out.println();
//    System.out.println(list.get(0));
//    System.out.println(list.get(1));
//    System.out.println(list.get(2));
//    System.out.println(list.get(3));
//    System.out.println(list.get(4));
  }

}
