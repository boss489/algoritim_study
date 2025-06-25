package com.inflearn.test0507;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = sc.next();
        String m = sc.next();
        System.out.println(new Main().solution(n, m));
    }

    private String solution(String n, String m) {
        Queue<Character> queue = new LinkedList<>();
        for(int i = 0; i < n.length(); i++){
            queue.offer(n.charAt(i));
        }
        for(int i = 0; i < m.length(); i++){
            if(queue.peek() == m.charAt(i))
                queue.poll();
            if(queue.isEmpty()) return "YES";
        }
        return "NO";
    }
}
