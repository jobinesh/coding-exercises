package com.jobinesh.exercise.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PancakeSorter {
    private void flip(int[] src, int len) {
        for (int i = 0; i <= len / 2; i++) {
            int tmp = src[i];
            src[i] = src[len - i];
            src[len - i] = tmp;
        }
    }

    private int max(int[] src, int len) {
        int maxIndex = 0;
        int max = src[0];
        for (int i = 1; i <= len; i++) {
            if (max < src[i]) {
                maxIndex = i;
                max = src[i];
            }
        }
        return maxIndex;
    }

    public List<Integer> sort(int[] numArray) {
        if (numArray == null) {
            return null;
        }
        if (numArray.length == 0) {
            return new ArrayList<>();
        }
        int src[] = new int[numArray.length];
        System.arraycopy(numArray, 0, src, 0, numArray.length);
        for (int i = src.length - 1; i >= 0; i--) {
            int max = max(src, i);
            if (max != i) {
                flip(src, max);
                flip(src, i);
            }
        }
        List<Integer> intList = new ArrayList<Integer>(src.length);
        for (int i : src) {
            intList.add(i);
        }
        return intList;
    }

    public static void main(String[] args) {
        int arr[] = {23, 10, 20, 11, 12, 6, 7, 90, 7, 40};
        System.out.println(Arrays.toString(arr));
        new PancakeSorter().sort(arr);

        System.out.println("Sorted Array: ");
        System.out.println(new PancakeSorter().sort(arr));
    }
}
