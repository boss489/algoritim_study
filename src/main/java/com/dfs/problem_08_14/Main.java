package com.dfs.problem_08_14;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static ArrayList<Point> homeList = new ArrayList<>();
    static ArrayList<Point> pizzaList = new ArrayList<>();
    static int[] combi;
    static int maxCnt;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        maxCnt  = sc.nextInt();
        combi = new int[maxCnt];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                int value = sc.nextInt();
                if(value == 1) {
                    homeList.add(new Point(i, j));
                } else if(value == 2) {
                    pizzaList.add(new Point(i, j));
                }
            }
        }
        new Main().solution(0, 0);
        System.out.println(answer);
    }
    public void solution(int cur, int index){
        if(cur == maxCnt){
            int sum = 0;
            for(int i = 0; i < homeList.size(); i++){
                int distance = Integer.MAX_VALUE;
                for(int j = 0; j < combi.length; j++){
                    int homeX = homeList.get(i).x;
                    int homeY = homeList.get(i).y;
                    int pizzaX = pizzaList.get(combi[j]).x;
                    int pizzaY = pizzaList.get(combi[j]).y;
                    distance = Math.min(distance, Math.abs(homeX - pizzaX) + Math.abs(homeY - pizzaY));
                }
                sum += distance;
            }
            answer = Math.min(answer, sum);
        }else {
            for (int i = index; i < pizzaList.size(); i++) {
                combi[cur] = i;
                solution(cur + 1,  i + 1);
            }
        }
    }
}
