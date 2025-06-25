package com.nepsec.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    class Quiz {
        int score;
        int time;

        public Quiz(int score, int time) {
            this.score = score;
            this.time = time;
        }
    }

    static int[] dy;
    public int solution(List<Quiz> quizzes, int limit) {
        dy = new int[limit + 1];
        Arrays.fill(dy, 0);
        for(int i = 1; i <= limit; i++) {
            for(Quiz quiz : quizzes) {
                if(i >= quiz.time) {
                    dy[i] = Math.max(dy[i], dy[i - quiz.time] + quiz.score);
                }
            }
        }
        return dy[limit];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int limit = scanner.nextInt();

        ArrayList<Quiz> quizzes = new ArrayList<>();
        for(int i =0; i < size; i++){
            quizzes.add(new Main().new Quiz(scanner.nextInt(), scanner.nextInt()));
        }
        System.out.println(new Main().solution(quizzes, limit));
    }
}
