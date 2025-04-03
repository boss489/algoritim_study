package com.inflearn.test12;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int input1 = in.nextInt();
        Main m = new Main();
        System.out.println(m.solution(input1, in.next()));
    }
    public String solution(int n, String s) {
        String answer = "";
        // 2진수 변환 함수
        for(int i =0; i < n ; i++){
            String temp = s.substring(0, 7).replace("#", "1").replace("*", "0");
            int num = Integer.parseInt(temp, 2);
            answer += (char)num;
            s = s.substring(7);
        }

        return answer;
    }
}