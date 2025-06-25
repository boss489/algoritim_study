package com.dynamic.highesttower;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Tower implements Comparable<Tower> {
    @Override
    public int compareTo(Tower o) {
        return o.areaSize - this.areaSize;
    }

    int areaSize;
    int height;
    int weight;

    public Tower(int areaSize, int height, int weight) {
        this.areaSize = areaSize;
        this.height = height;
        this.weight = weight;
    }
}

public class Main {
    static int[] dy;

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int input1 = in.nextInt();
        dy = new int[input1];

        ArrayList<Tower> towers = new ArrayList<>();
        for(int i = 0; i < input1; i++){
            towers.add(new Tower(in.nextInt(), in.nextInt(), in.nextInt()));
        }
        Main main = new Main();
        int answer = main.solution(towers);
        System.out.println(answer);
    }

    private int solution(ArrayList<Tower> towers) {
        Collections.sort(towers);
        dy[0] = towers.get(0).height;
        int answer = dy[0];
        for(int i = 1; i < towers.size(); i++){
            int max_height = 0;
            for(int j = i - 1; j >= 0; j--) {
                if (towers.get(i).weight < towers.get(j).weight && dy[j] > max_height) {
                    max_height = dy[j];
                }
            }
            dy[i] = max_height + towers.get(i).height;
            answer = Math.max(answer, dy[i]);
        }
        return answer;
    }
}
