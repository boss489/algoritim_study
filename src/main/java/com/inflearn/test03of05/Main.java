package com.inflearn.test03of05;

import java.util.Scanner;

// https://cote.inflearn.com/contest/10/problem/03-05
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Main t = new Main();
        int a = t.solution(n);
        System.out.println(a);
    }

    private int solution(int n) {
        int sum = 0;
        int lt = 1;
        int result = 0;
        for(int rt = 1; rt < n  ; rt++){
            sum += rt;
            if(sum == n) {
                result++;
            }
            while(sum > n) {
              sum -= lt++;
                if(sum == n) {
                    result++;
                }
            }
        }
        return result;
    }


}
