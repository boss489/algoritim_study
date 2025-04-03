package com.inflearn.test2of13;

import java.util.Scanner;

public class Main {
    //https://cote.inflearn.com/contest/10/problem/03-06
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i< n; i++){
            arr[i] = sc.nextInt();
        }
        Main main = new Main();
        System.out.println(main.solution(n, k , arr));
    }

    private int solution(int n, int k, int[] arr) {
        int length = 0;
        int cnt = 0;
        int lt = 0;
        int result = Integer.MIN_VALUE;

        for(int ridx = 0 ; ridx < n; ridx++){
            if(arr[ridx] == 0) cnt++;
            while(cnt > k){
                if(arr[lt] == 0) cnt--;
                lt++;
            }
           result  = Math.max(result, ridx - lt + 1);
        }
        return result;
    }
}
