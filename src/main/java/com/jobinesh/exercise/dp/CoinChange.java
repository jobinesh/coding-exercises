package com.jobinesh.exercise.dp;

import java.util.Arrays;

public class CoinChange {
    public int coinChange1(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 0; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public int coinChange(int[] coins, int amount) {
        int result = -1;
        int dp[] = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 0; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if( coins[j]<=i)
                dp[i] = Math.min(dp[i], dp[i-coins[j]]+1);
            }
        }
        if(dp[amount ]<=amount){
            result = dp[amount];
        }
        return result;
    }
    public static void main(String[] args){
        System.out.println( new CoinChange().coinChange(new int[]{1,2,5},11 ));
        System.out.println( new CoinChange().coinChange(new int[]{2},3 ));
    }
}
