package com.jobinesh.exercise.sort;

import java.util.Arrays;

public class QuickSort {
    public void sort(int[] src) {
        quickSort(src, 0, src.length - 1);
    }

    private void quickSort(int[] src, int low, int high) {
        if (low < high) {
            int pivot = partition(src, low, high);
            quickSort(src, low, pivot - 1);
            quickSort(src, pivot + 1, high);
        }
    }

    private int partition(int[] src, int low, int high) {
        int pivot = src[high];
        int i = low;//-1;
        int j = low;
        while (j <= high - 1) {
            if (src[j] < pivot) {
               // i++;
                int tmp = src[i ];
                src[i ] = src[j];
                src[j] = tmp;
                i++;
            }
            j++;
        }
        //i++;
        int tmp = src[i ];
        src[i ] = src[high];
        src[high] = tmp;

        return i ;
    }

    public static void main(String arg[]) {
        int[] src = {2,-9,8, 9, 3, 7, 5, 0, 4};
        //int src[] = { 12, 11, 13, 5, 6, 7 };
        new QuickSort().sort(src);
        System.out.println(Arrays.toString(src));

    }
}
