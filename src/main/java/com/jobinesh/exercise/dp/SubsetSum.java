package com.jobinesh.exercise.dp;

/**
 * Given a set of positive numbers, determine if
 * there exists a subset whose sum is equal to a given number ‘S’.
 */
public class SubsetSum {
    static boolean canPartition(int[] num, int sum) {
        //TODO: Write - Your - Code
        Boolean[][] dep = new Boolean[num.length][sum + 1];
        return canPartition(dep, num, 0, sum);
    }

    private static boolean canPartition(Boolean[][] dep, int[] num, int index, int sum) {
        if (index >= num.length || num.length == 0) {
            return false;
        }
        if (sum == 0) {
            return true;
        }
        if (sum < 0) {
            return false;
        }
        if (dep[index][sum] == null) {
            if (num[index] <= sum) {
                if (canPartition(dep, num, index + 1, sum - num[index])) {
                    dep[index][sum] = true;
                    return dep[index][sum];
                }

            }
            dep[index][sum] = canPartition(dep, num, index + 1, sum);

        }
        return dep[index][sum];
    }

    public static void main(String[] args) {
        SubsetSum ss = new SubsetSum();
        int[] num = {1, 2, 3, 7};
        System.out.println(ss.canPartition(num, 6));
        num = new int[]{1, 2, 7, 1, 5};
        System.out.println(ss.canPartition(num, 10));
        num = new int[]{1,3, 3, 4, 8};
        System.out.println(ss.canPartition(num, 6));
    }
}
