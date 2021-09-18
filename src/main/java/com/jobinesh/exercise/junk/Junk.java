package com.jobinesh.exercise.junk;


import java.util.Arrays;

public class Junk {
    public static void pancakeSortJP(int[] src) {
    }

    public static void selectionSortJP(int[] src) {

        for (int i = 0; i < src.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < src.length; j++) {
                System.out.println("i:" + i + " minIndex:" + minIndex);
                if (src[j] < src[minIndex]) {
                    minIndex = j;
                }
            }
            if (i != minIndex) {
                int tmp = src[i];
                src[i] = src[minIndex];
                src[minIndex] = tmp;
            }
        }
    }

    public static void bubbleSortJP(int[] src) {
        for (int i = 0; i < src.length - 1; i++) {
            for (int j = 0; j < src.length - i - 1; j++) {
                if (src[j] > src[j + 1]) {
                    int tmp = src[j + 1];
                    src[j + 1] = src[j];
                    src[j] = tmp;
                }
            }
        }

    }

    public static void quickSortJP(int[] src) {
        doquickSort(src, 0, src.length - 1);
    }

    public static void insertionSortJP(int[] src) {

        for (int i = 1; i < src.length; i++) {
            int j = i - 1;
            int current = src[i];
            while (j >= 0
                    && src[j] > current) {
                src[j + 1] = src[j];
                j--;
            }
            src[j + 1] = current;
        }
    }

    public static void doquickSort(int[] src, int low, int high) {
        if (low < high) {
            int pivot = pivot(src, low, high);
            doquickSort(src, low, pivot - 1);
            doquickSort(src, pivot + 1, high);
        }
    }

    public static int pivot(int[] src, int low, int high) {
        int pivot = src[high];
        int i = low;
        int j = low;
        while (j < high) {
            if (src[j] < pivot) {
                int tmp = src[j];
                src[j] = src[i];
                src[i] = tmp;
                i++;
            }
            j++;
        }
        int tmp = src[i];
        src[i] = pivot;
        src[high] = tmp;
        return i;
    }

    public static void main(String arg[]) {
        int[] src = {2, 9, 3, 7, 5, 0, 4};
        insertionSortJP(src);
        System.out.println(Arrays.toString(src));
        // JUnitCore.main(BubbleSort.class.getName());
    }
}
