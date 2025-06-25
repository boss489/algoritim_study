package com.greedy.problem_09_04;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    static class Lecture implements Comparable<Lecture> {
        @Override
        public int compareTo(@NotNull Lecture o) {
            if (this.waitingTime == o.waitingTime) {
                return  o.money - this.money;
            }
            return  o.waitingTime - this.waitingTime;

        }
        int money;
        int waitingTime;
        public Lecture(int money, int waitingTime) {
            this.money = money;
            this.waitingTime = waitingTime;
        }

    }
    static int maxDate = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        ArrayList<Lecture> Player = new ArrayList<>();
        for(int i = 0 ; i < num; i++){
            int start = sc.nextInt();
            int end = sc.nextInt();
            maxDate = Math.max(end, maxDate);
            Player.add(new Lecture(start, end));
        }
        int result = new Main().solution(Player);
        System.out.println(result);
    }

    private int solution(ArrayList<Lecture> player) {
        Collections.sort(player);
        
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        ArrayList<Integer> moneyList = new ArrayList<>();
        int curLevel = player.get(0).waitingTime;
        int i = 0;
        for(int j = maxDate; j >= 1; j--) {
            for(; i < player.size(); i++) {
                if(curLevel == player.get(i).waitingTime) {
                    queue.offer(player.get(i).money);
                }else{
                    break;
                }
            }
            moneyList.add(queue.poll());
        }

        int result = moneyList.stream().mapToInt(Integer::intValue).sum();

        return result;
    }







}
