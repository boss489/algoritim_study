package com.inflearn.test0405;

import java.util.*;

public class Main {
    //https://cote.inflearn.com/contest/10/problem/04-03
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i ++){
            arr[i] = sc.nextInt();
        }
        Main s = new Main();
        System.out.print(s.solution(n, m, arr));
    }

    private Integer solution(int n, int m, int[] arr) {
        TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());
        for(int i = 0; i < arr.length; i++){
            for(int k = i + 1; k < arr.length; k++){
                for(int j = k + 1; j < arr.length; j++){
                    set.add(arr[i] + arr[k] + arr[j]);
                }
            }
        }
        Iterator<Integer> iterator = set.iterator();
        int result = Integer.MIN_VALUE;

        int seq = 0;
        while(iterator.hasNext()){
            Integer next = iterator.next();
            if(seq == m - 1) return next;
            seq++;
        }
        return -1;
    }
}
