package com.scanner.ex1;

import java.util.Scanner;

public class ScannerEx {
    //간단한 문자열 처리는 scanner로

    //자연수 n과 m을 간단히 입력받는 문제
    // 3 1
    // 2 4

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        for(int i = 0; i < n; i ++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            sc.nextLine(); //버퍼 비우기, 개행문자 제거
            System.out.println("다시" + a + " " + b + " " + (a+b));
            if(i == 999){
                System.out.println("끝");
                return ;
            }
        }
    }
}
