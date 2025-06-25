package com.inflearn.test04of03;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

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
        for(Integer a : s.solution(n, m, arr)){
            System.out.print(a + " ");
        }
    }

    private ArrayList<Integer> solution(int n, int m, int[] arr) {
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            if(i <= m-1) map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            if(i == m-1) result.add(map.size());
            if(i >= m){
                map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
                map.put(arr[i - m], map.getOrDefault(arr[i - m], 1) - 1);
                if( map.get(arr[i-m]) == 0){
                    map.remove(arr[i-m]);
                }
                result.add(map.size());
            }
        }
        return result;
    }
}
