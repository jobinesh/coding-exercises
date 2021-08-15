package com.jobinesh.exercise.dp;

import java.util.Arrays;

/**
 * Given a set of positive numbers,
 * find if we can partition it into two subsets such that the sum of elements in both the subsets is equal.
 */
public class EqualSubset {
    static boolean canPartition(int[] num) {
        //TODO: Write - Your - Code
        int sum = Arrays.stream(num).sum();
        if (sum % 2 != 0) {
            return false;
        }
        sum = sum / 2;
        Boolean elqualsMem[][] = new Boolean[num.length][sum+1];
        return doCheckPartition(elqualsMem,num, 0, sum);
    }

    static boolean doCheckPartition( Boolean elqualsMem[][],int[] num, int index, int sum) {
        //TODO: Write - Your - Code

        if (sum == 0) {
          return true;
        }
        if (num.length ==0 || index >= num.length) {
            return false;
        }
        if(elqualsMem[index][ sum ] == null) {
            if (num[index] <= sum) {
                if (doCheckPartition(elqualsMem, num, index + 1, sum - num[index])) {
                    elqualsMem[index][sum] = true;
                    return true;
                }
            }
            elqualsMem[index][sum] = doCheckPartition(elqualsMem, num, index + 1, sum);
        }
        return  elqualsMem[index][ sum];
    }

    public static void main(String[] args) {
        EqualSubset ps = new EqualSubset();
        int[] num = {1, 2, 3, 4};
        System.out.println(ps.canPartition(num));
        num = new int[]{1, 1, 3, 4, 7};
        System.out.println(ps.canPartition(num));
        num = new int[]{2, 3, 4, 6};
        System.out.println(ps.canPartition(num));
    }
}
