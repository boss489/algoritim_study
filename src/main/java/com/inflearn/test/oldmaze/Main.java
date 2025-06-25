package com.inflearn.test.oldmaze;

import java.util.Scanner;

public class Main {
    static int RESULT = 0;
    public static int[][] direction = {
            {0, 1}, // right
            {1, 0}, // down
            {0, -1}, // left
            {-1, 0} // up
    };
    static int[][] arr = new int [7][7];
    static int[][] visited = new int [7][7];
    public void dfs(int cx, int cy){
        if(cx == 6 && cy == 6){
            RESULT++;
        }else{
            for(int i = 0; i < 4; i++){
                int nx = cx + direction[i][0];
                int ny = cy + direction[i][1];
                if(nx >= 0 && nx < 7 && ny >= 0 && ny < 7 && arr[nx][ny] == 0 && visited[nx][ny] == 0){
                    visited[nx][ny] = 1;
                    dfs(nx, ny);
                    visited[nx][ny] = 0;
                }
            }
        }
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        for(int i = 0 ; i < arr.length; i ++) {
            for (int j = 0; j < arr.length; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        visited[0][0] = 1;
        new Main().dfs(0, 0);
        System.out.println(RESULT);
    }


}
