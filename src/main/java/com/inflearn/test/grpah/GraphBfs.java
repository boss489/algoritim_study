package com.inflearn.test.grpah;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GraphBfs {
    static int n, m;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] ch, dis;

    public void DFS(int v){
      Queue<Integer> queue = new LinkedList<>();
      ch[v] = 1;
      dis[v] = 0;
      queue.offer(v);
      while(!queue.isEmpty()){
          int cv = queue.poll();
          for(int nv : graph.get(cv)){
              if(ch[nv] == 0){
                  ch[nv] = 1;
                  queue.offer(nv);
                  dis[nv] = dis[cv] + 1;
              }
          }
      }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        graph = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<Integer>());
        }
        ch = new int[n+1];
        for(int i = 0; i<m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
        }
        // ch[1] = 1;
        new LoadSearch().DFS(1);
        for(int i = 2; i <= n; i++){
            System.out.print(i + " " + dis[i]);
        }
    }
}
