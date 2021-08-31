package com.jobinesh.exercise.dp;

/**
 * Given two integer arrays to represent weights and profits of ‘N’ items,
 * we need to find a subset of these items which will give us maximum profit such
 * that their cumulative weight is not more than a given number ‘C’.
 * Write a function that returns the maximum profit.
 * Each item can only be selected once, which means either we put an item in the knapsack or skip it.
 */
public class KnapSackBotttomUp {
    public int solveKnapsack(int[] profits, int[] weights, int capacity) {
        // TODO: Write your code here
        int[][] dp=new int[profits.length][capacity+1];
        for(int i=0;i<profits.length;i++){
            dp[i][0]=0;
        }
        for(int c=0; c <= capacity; c++) {
            if(weights[0] <= c)
                dp[0][c] = profits[0];
        }
        for(int i=1;i<profits.length;i++){
            for(int currentCapacity=1;currentCapacity<=capacity;currentCapacity++){
                if(weights[i]<=currentCapacity){
                    dp[i][currentCapacity] = profits[i]+ dp[i-1][currentCapacity-weights[i]];
                }
                dp[i][currentCapacity] = Math.max(dp[i][currentCapacity], dp[i-1][currentCapacity] );
            }
        }

        return  dp[profits.length-1][capacity] ;
    }

    public static void main(String[] args) {
        KnapSackBotttomUp ks = new KnapSackBotttomUp();
        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};
        int maxProfit = ks.solveKnapsack(profits, weights, 7);
        System.out.println("Total knapsack profit ---> " + maxProfit);
        maxProfit = ks.solveKnapsack(profits, weights, 6);
        System.out.println("Total knapsack profit ---> " + maxProfit);
    }
}
