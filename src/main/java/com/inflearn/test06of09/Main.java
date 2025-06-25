package com.inflearn.test06of09;

import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n; i++){
            arr[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        System.out.println(new Main().solution(n, m, arr));
    }

    public int solution(int n, int m, int[] arr){
        StringBuilder sb = new StringBuilder();
        Queue<Integer> queue = new java.util.LinkedList<>();
        Arrays.sort(arr);
        int answer = 0;
        int rt = Arrays.stream(arr).sum();
        int lt = arr[arr.length - 1];
        while(lt <= rt){
            int mid = (lt + rt) / 2;
            if(devidedCount(arr, mid) <= m){
                answer = mid;
                rt = mid - 1;
            }else{
                lt = mid + 1;
            }
        }

        return answer;
    }

    private int devidedCount(int[] arr, int capacity) {
        int sum = 0;
        int answer = 1;
        for(int x : arr){
            if(sum + x > capacity){
                answer++;
                sum = x;
            } else {
                sum += x;
            }
        }
        return answer;
    }
}
