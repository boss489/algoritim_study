package com.dfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    int answer = 0;
    int[] dis = {1, -1, 5};
    int[] ch;
    Queue<Integer> Q = new LinkedList<>();

    public int bfs(int s, int e){
        ch = new int[100001];
        ch[s] = 1;
        Q.offer(s);
        int L = 0;
        while (!Q.isEmpty()){
            int len = Q.size();
            for(int i = 0 ; i < len; i++){
                int x = Q.poll();
                if(x == e) return L;
                for(int j = 0; i < 3; j++){
                    int nx = x + dis[j];
                    if(nx >= 1 && nx <= 10000 && ch[nx] == 0){
                        ch[nx] = 1;
                        Q.offer(nx);
                    }
                }
            }
            L++;

        }
        return 0;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Main main = new Main();
        int s = in.nextInt();
        int e = in.nextInt();
        System.out.println(new Main().bfs(s,e));
        return ;
    }
}