package com.dynamic;

import java.util.Scanner;

public class Chair {
    public int result = 0 ;
    public int sdlution(int curLevel, int toplevel){

        if(curLevel > toplevel) return 0;
        else if(curLevel == toplevel)  return result++;
        else {
            sdlution(curLevel + 1, toplevel);
            sdlution(curLevel + 2, toplevel);
        }
       return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Chair chair = new Chair();
        System.out.println(chair.sdlution(0, sc.nextInt()));

    }
}
