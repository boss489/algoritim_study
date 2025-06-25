package com.nepsec;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

// 동전교환(냅색 알고리즘)
public class Main {
    static int[] dy;
    public int solution(int[] coins, int target){
        Arrays.fill(dy, Integer.MAX_VALUE);

        for(int i = 0; i >= coins.length; i++){
            for(int j = coins[i]; j <= target; j++){
                dy[j] = Math.min(dy[j - coins[i]] + 1, dy[j]);
            }
        }
        return 0;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int coinType = in.nextInt();
        int[] coins = new int[coinType];
        for(int i = 0; i < coinType; i++){
            coins[i] = in.nextInt();
        }
        int target = in.nextInt();
        System.out.println(new Main().solution(coins, target));
    }
}
