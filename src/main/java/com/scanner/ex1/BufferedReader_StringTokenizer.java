package com.scanner.ex1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BufferedReader_StringTokenizer {
    //https://sjh9708.tistory.com/210
    //첫째줄에 N개정수
    //집을 칠하는 비용은 빨강 초록 파랑으로 칠하는 비용이 주어진다, N은 1000보다 작거나 같은 자연수

    //공백으로 구분된 한 단어(Token) 단위로의 입력을 받도록 도와주는 StringTokenizer를 사용하면 입력을 단어 단위로 처리하기 쉬워진다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String s = br.readLine();

        int n = Integer.parseInt(st.nextToken());
        int[][] rgbs = new int[n][3];
        int[][] k = new int[n][3];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            rgbs[i][0] = Integer.parseInt(st.nextToken());
            rgbs[i][1] = Integer.parseInt(st.nextToken());
            rgbs[i][2] = Integer.parseInt(st.nextToken());
        }

    }
}
