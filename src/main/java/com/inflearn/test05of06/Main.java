package com.inflearn.test05of06;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    //https://cote.inflearn.com/contest/10/problem/05-06
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        System.out.println(new Main().solution(n, m));
    }

    private int solution(int n, int m) {
        int result = 0;
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= n; i++){
            queue.offer(i);
        }

        while(queue.size() > 1){
            for(int i = 0; i < m; i++) queue.offer(queue.poll());
            queue.poll();
            if(queue.size() == 1) result = queue.poll();

        }

        return result;
    }
}
