package com.inflearn.test2of10;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public int solution(int n, int[][] arr) {
        int result = 0;
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < n+1; j++) {
                if (arr[i][j] > arr[i + 1][j]
                        && arr[i][j] > arr[i - 1][j]
                        && arr[i][j] > arr[i][j + 1]
                        && arr[i][j] > arr[i][j - 1]) {
                    result++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n+2][n+2];
        for(int i = 1; i < n+1; i++){
            for(int j = 1 ; j < n+1; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        Main m = new Main();
        System.out.println(m.solution(n, arr));
    }

}
