package com.greedy.promblem_09_03;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    static class Lecture implements Comparable<Lecture> {
        @Override
        public int compareTo(@NotNull Lecture o) {
            if(this.time == o.time) {
                return this.type.compareTo(o.type);
            }
            return this.time - o.time;
        }

        int time;
        String type;

        public Lecture(int time, String type) {
            this.time = time;
            this.type = type;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        ArrayList<Lecture> Player = new ArrayList<>();
        for(int i = 0 ; i < num; i++){
            int start = sc.nextInt();
            int end = sc.nextInt();
            Player.add(new Lecture(start, "S"));
            Player.add(new Lecture(end, "E"));
        }
        int result = new Main().solution(Player);
        System.out.println(result);
    }

    private int solution(ArrayList<Lecture> player) {
        Collections.sort(player);
        int tempEt = Integer.MAX_VALUE;
        int finalResult = 0;
        int result = 0;
        for(int i = 0; i < player.size(); i++) {
            if (player.get(i).type.equals("S")){
                result++;
                finalResult = Math.max(finalResult, result);
            }
            else {
                result--;
            }
        }
        return finalResult;
    }

}
