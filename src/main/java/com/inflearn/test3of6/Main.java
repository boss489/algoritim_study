package com.inflearn.test3of6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0 ; i < n; i++){
            arr[i] = sc.nextInt();
        }
        Main t = new Main();
        for(Integer a : t.solution(n, arr)){
            System.out.print(a + " ");
        }
    }

    public List<Integer> solution(int n, int[] arr) {
        List<Integer> answer = new ArrayList<>();
        for(int i= 0 ; i < n; i++){
            int tmp = arr[i];
            int cnt = 0;
            while(tmp > 0){
                cnt = cnt * 10 + tmp % 10;
                tmp = tmp / 10;
            }
            if(isPrime(cnt)){
                answer.add(cnt);
            }
        }
        return answer;
    }

    private boolean isPrime(int cnt) {
        if(cnt == 1) return false;
        for(int i = 2; i < cnt; i++){
            if(cnt % i == 0) return false;
        }
        return true;
    }
}