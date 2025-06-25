package com.greedy.problem_09_02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    static class MeetingTime implements Comparable<MeetingTime> {
        int start;
        int end;

        public MeetingTime(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(MeetingTime o) {
            if (this.end == o.end) {
                return this.start - o.start; // If end times are equal, sort by start time
            }
            return this.end - o.end;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        ArrayList<MeetingTime> meetings = new ArrayList<>();
        for(int i = 0 ; i < num; i++){
            int start = sc.nextInt();
            int end = sc.nextInt();
            meetings.add(new MeetingTime(start, end));
        }
        int result = new Main().solution(meetings);
        System.out.println(result);
    }

    private int solution(ArrayList<MeetingTime> meetings) {
        Collections.sort(meetings);
        int result = 0;
        int endTime = 0;
        for(int i = 0; i < meetings.size(); i++) {
            if(meetings.get(i).start >= endTime) {
                result++;
                endTime = meetings.get(i).end;
            }
        }
        return result;
    }
}
