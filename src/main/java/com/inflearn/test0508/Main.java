package com.inflearn.test0508;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Person{
    int id;
    int priority;

    public Person(int id, int priority) {
        this.id = id;
        this.priority = priority;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(new Main().solution(n, m, arr));
    }

    private String solution(int n, int m, int[] arr){
        Queue<Person> queue = new LinkedList<>();
        for(int i = 0; i < n; i++){
            queue.offer(new Person(i, arr[i]));
        }

        while(!queue.isEmpty()){

        }
        return "";
    }
}
