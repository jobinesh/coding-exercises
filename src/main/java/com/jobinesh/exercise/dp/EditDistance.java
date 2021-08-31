package com.jobinesh.exercise.dp;

public class EditDistance {
    public int findMinOperations(String str1, String str2) {
        Integer[][] dp = new Integer[str1.length() + 1][str2.length() + 1];

        return findDistance(dp, str1, str2, 0, 0);
    }

    public int findDistance(Integer[][] dp, String str1, String str2, int index1, int index2) {

        if (dp[index1][index2] == null) {
            if (index1 == str1.length()) {
                dp[index1][index2] = str2.length() - index2;
            } else if (index2 == str2.length()) {
                dp[index1][index2] = str1.length() - index1;
            } else if (str1.charAt(index1) == str2.charAt(index2)) {
                dp[index1][index2] = findDistance(dp, str1, str2, index1 + 1, index2 + 1);
            } else {
                int cnt1 = findDistance(dp, str1, str2, index1 + 1, index2);
                int cnt2 = findDistance(dp, str1, str2, index1, index2 + 1);
                int cnt3 = findDistance(dp, str1, str2, index1 + 1, index2 + 1);
                dp[index1][index2] = 1 + Math.min(cnt1, Math.min(cnt2, cnt3));
            }
        }
        return dp[index1][index2];
    }

    public static void main(String[] args) {
        EditDistance editDisatnce = new EditDistance();
        System.out.println(editDisatnce.findMinOperations("bat", "but"));
        System.out.println(editDisatnce.findMinOperations("abdca", "cbda"));
        System.out.println(editDisatnce.findMinOperations("passpot", "ppsspqrt"));
    }
}
