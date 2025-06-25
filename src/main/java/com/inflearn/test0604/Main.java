package com.inflearn.test0604;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

//https://cote.inflearn.com/contest/10/problem/06-06
class Point implements Comparable<Point> {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point o) {
        if (this.x == o.x) {
            return this.y - o.y;
        }
        return this.x - o.x;
    }


}
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] m = new int[n];
        for(int i = 0 ; i < n; i++){
            m[i] = sc.nextInt();
        }
        System.out.println(new Main().solution(n, m));


    }

    private String solution(int n, int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        int[] origin = Arrays.copyOf(arr, arr.length);
        Arrays.sort(arr);
        for(int i = 0; i < arr.length; i++){
            if(arr[i] != origin[i]){
                list.add(origin[i]);
            }
        }
        Collections.sort(list);
        return list.toString();
    }
}
