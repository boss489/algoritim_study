package com.inflearn.test04of01;

import java.util.HashMap;
import java.util.Scanner;

//https://cote.inflearn.com/contest/10/problem/04-01
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        System.out.println(main.solution(n, s));
    }

    private Character solution(int n, String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int resultCnt = 0;
        Character resultKey = ' ';
        for(int i = 0; i < s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
        }

        for(Character key : map.keySet()){
            if(resultCnt < map.get(key)){
                resultKey = key;
                resultCnt = map.get(key);
            }
        }
        return resultKey;
    }
}
