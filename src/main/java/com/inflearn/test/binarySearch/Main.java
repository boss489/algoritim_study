package com.inflearn.test.binarySearch;

import java.util.Arrays;
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
       int lt = 0; int rt = arr.length - 1;

       while(lt <= rt){
           int mid = rt - lt / 2;
           if(arr[mid] == m){
               return mid + 1;
           } else if(arr[mid] > m) {
               rt = mid - 1;
           } else {
               lt = mid + 1;
           }
       }
        return -1;
    }

}
