package com.inflearn.test11;

import java.util.Scanner;

public class Main {


    public static void main(String[] args){
        Main main = new Main();
        Scanner in=new Scanner(System.in);
        String input1 = in.next();

        System.out.print(main.solution(input1));
        return ;
    }
    public String solution(String s){
        String answer = "";
        s = s+ " ";
        StringBuilder sb = new StringBuilder();
        int cnt = 1;
        for(int i = 0; i < s.length() - 1; i++){
            if(s.charAt(i) == s.charAt(i+1)){
                cnt++;
            }else{
                answer += s.charAt(i);
                if(cnt>1) answer += String.valueOf(cnt);
                cnt =1 ;
            }
        }
        return answer;
    }
}