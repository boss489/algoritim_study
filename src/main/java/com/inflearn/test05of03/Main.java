package com.inflearn.test05of03;

import java.util.Scanner;
import java.util.Stack;

public class Main {
//    https://cote.inflearn.com/contest/10/problem/05-03
//            5
//            0 0 0 0 0
//            0 0 1 0 3
//            0 2 5 0 1
//            4 2 4 4 2
//            3 5 1 3 1
//            8
//            1 5 3 5 1 2 1 4

//            4
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        for(int i = 0 ; i < n; i++){
            for(int j = 0 ; j < n; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        int m = sc.nextInt();
        int[] moves = new int[m];
        for(int i = 0 ; i < m; i ++){
            moves[i] = sc.nextInt();
        }
        Main main = new Main();
        System.out.println(main.solution(n, arr, m, moves));
    }

    public int solution(int n, int[][] arr, int m, int[] crain){
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        for(int i = 0; i < m; i++){
            int idx = crain[i] - 1;
            for(int j = 0; j < n; j++){
               if(arr[j][idx] != 0) {
                   if(stack.isEmpty() || stack.peek() != arr[j][idx]) {
                       stack.push(arr[j][idx]);
                   }else {
                       result += 2;
                       stack.pop();
                   }
                   arr[j][idx] = 0;
                   break;
               }
            }
        }
        return result;
    }
}
