package algorithm.test.codetree;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        int arrA[] = new int[100];
        int arrB[] = new int[100];

        for(int i = 0; i < a; i++){
            arrA[i] = sc.nextInt();
        }
        for(int i = 0; i < b; i++){
            arrB[i] = sc.nextInt();
            if(arrA[i] != arrB[i]){
                arrA[i++];
                System.out.printf(arrA + " ");
            }else if(arrA[i] == arrB[i]){
                
            }
        }
  }
}
