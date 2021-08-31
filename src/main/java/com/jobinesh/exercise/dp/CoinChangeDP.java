package com.jobinesh.exercise.dp;

/*
Given an infinite supply of ‘n’ coin denominations and a total money amount,
we are asked to find the total number of distinct ways to make up that amount.
 */
public class CoinChangeDP {
    public int countChange(int[] denominations, int total) {
        // TODO: Write your code here
        Integer[][] dp=new Integer[denominations.length+1][total+1];
        return findTotalChange(dp, denominations, 0, total);
    }

    public int findTotalChange( Integer[][] dp,int[] denominations, int index, int total) {
        // TODO: Write your code here
        if (total == 0) {
            return 1;
        }
        if (denominations.length <= index){
            return 0;
        }
        int cnt1 = 0;
        int cnt2;
        if (denominations[index] <= total) {
            if(dp[index][total - denominations[index]] == null ) {
                cnt1 = findTotalChange(dp,denominations, index, total - denominations[index]);
                dp[index][total - denominations[index]]=cnt1;
            }else{
                cnt1=  dp[index][total - denominations[index]];
            }

        }

        if(dp[index+1][total] == null ) {
            cnt2 = findTotalChange(dp, denominations, index + 1, total);
            dp[index+1][total]=cnt2;
        }else{
            cnt2=  dp[index+1][total];
        }

        return cnt1 + cnt2;
    }

    public static void main(String[] args) {
        CoinChangeDP cc = new CoinChangeDP();
        int[] denominations = {1, 5, 10};
        System.out.println(cc.countChange(denominations, 12));
    }
}
