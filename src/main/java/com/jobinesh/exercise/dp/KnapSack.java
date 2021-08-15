package com.jobinesh.exercise.dp;

/**
 * Given two integer arrays to represent weights and profits of ‘N’ items, we need to find a subset of
 * these items which will give us maximum profit such that their cumulative weight is not more than a given
 * number ‘C’. Write a function that returns the maximum profit. Each item can only be selected once, which
 * means either we put an item in the knapsack or skip it.
 */
public class KnapSack {
    public int solveKnapsack(int[] profits, int[] weights, int capacity) {

       Integer memoizedProfits[][] = new Integer[profits.length][capacity+1];
       return doKnapsack(memoizedProfits,profits,weights,0,capacity);
    }

    public int doKnapsack(Integer memoizedProfits[][],int[] profits, int[] weights, int index, int capacity) {
        if( capacity<=0 || index>= profits.length){
            return 0;
        }
        int profit1=0;
        int profit2;
        if(memoizedProfits[index][capacity] != null){
            return memoizedProfits[index][capacity];
        }
        if (weights[index] <= capacity) {
             profit1 = profit1 +profits[index]+ doKnapsack(memoizedProfits,profits, weights,index+1, capacity-weights[index]);
        }
        profit2 = doKnapsack(memoizedProfits,profits, weights,index+1, capacity);

        memoizedProfits[index][capacity]=Math.max(profit1, profit2);
        return  memoizedProfits[index][capacity];
    }

    public static void main(String[] args) {
        KnapSack ks = new KnapSack();
        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};
        int maxProfit = ks.solveKnapsack(profits, weights, 7);
        System.out.println("Total knapsack profit ---> " + maxProfit);
        maxProfit = ks.solveKnapsack(profits, weights, 6);
        System.out.println("Total knapsack profit ---> " + maxProfit);
    }
}
