package com.dynamic;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;

class Brick implements Comparable<Brick> {
    public int s, h, w;

    public Brick(int s, int h, int w) {
        this.s = s;
        this.h = h;
        this.w = w;
    }

    @Override
    public int compareTo(@NotNull Brick o) {
        return o.s - this.s;
    }
}

public class BricksQuestion {
    static int[] dy;
    public int solution(ArrayList<Brick> bricks) {
        Collections.sort(bricks);
        for(int i = 1; i < bricks.size() - 1; i++) {
            int max_h = 0;
            for(int j = i - 1 ; j >= 0; j--) {
                if(bricks.get(i).w < bricks.get(j).w && dy[j] > max_h) {
                    max_h = dy[j];
                }
            }
            dy[i] = max_h + bricks.get(i).h;
        }
        return 0;
    }
}
