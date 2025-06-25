package com.greedy.problem_09_10;

import org.jetbrains.annotations.NotNull;

import java.util.Scanner;

public class Main {
    static class Player implements Comparable<Player> {
        @Override
        public int compareTo(@NotNull Player o) {
            return o.white - this.white;
        }

        int white;
        int black;

        public Player(int white, int black) {
            this.white = white;
            this.black = black;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        for(int i = 0 ; i < num; i++){
            int white = sc.nextInt();
            int black = sc.nextInt();
        }
    }
}
