package com.inflearn.test10;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        Main t = new Main();
        String input1 = in.next();
        char input2 = in.next().charAt(0);
        for(int x : t.solution(input1, input2)){
            System.out.print(x + " ");
        }

        return ;
    }

    public int[] solution(String s, char t){
        int[] answer = new int[s.length()];
        int p = 9999;

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == t){
                answer[i] = 0;
                p = 0;
            }else {
                answer[i] = ++p;
            }
        }

        for(int i = s.length() - 1; i == 0; i--){
            if(s.charAt(i) == t){
                answer[i] = 0;
                p = 0;
            }else {
                p++;
                p = Math.min(answer[i], p);
                answer[i] = p;
            }
        }
        return answer;
    }
}