package algorithm.test.codetree;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
   

        char[] word = new char[]{'L','E','B','R','O','S'};
        char c = sc.next().charAt(0);

        int idx = -1;

        for(int i=0; i<6;i++){
            if(word[i] == 'L'){
                idx = i;
             }else if(word[i] == 'E'){
                 idx = i;
             }else if(word[i] == 'B'){
                 idx = i;
             }else if(word[i] == 'R'){
                 idx = i;
             }else if(word[i] == 'O'){
                 idx = i;
             }else if(word[i] == 'S'){
                 idx = i;
             }

        }
        if (idx == -1) {
            System.out.println("None");
        }
        else {
            System.out.println(idx);
        }
    }
}



}}
