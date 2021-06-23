package com.jobinesh.exercise.sort;

import org.junit.runner.JUnitCore;

import java.util.Arrays;

public class MergeSort {

    public void sort(int[] src) {
        mergeSort(src, 0, src.length - 1);
    }

    private void mergeSort(int[] src, int low, int high) {
        System.out.println("low:" + low + " high:" + high);
        if (low < high) {
            int med =low+ (high-low)/2; ;
            mergeSort(src, low, med);
            mergeSort(src, med + 1, high);
            merge(src, low, med, high);
        }
    }

    private void merge(int[] src, int low, int med, int high) {
        int size1 = med - low + 1;
        int size2 = high - med;
        int[] array1 = new int[size1];
        int[] array2 = new int[size2];
        int i = 0;
        while (i < size1) {
            array1[i] = src[i + low];
            i++;
        }
        int j = 0;
        while (j < size2) {
            array2[j] = src[j + med + 1];
            j++;
        }
        int index = low;
        i = 0;
        j = 0;
        while (i < size1 && j < size2) {
            if (array1[i] <= array2[j]) {
                src[index] = array1[i];
                i++;
            } else {
                src[index] = array2[j];
                j++;
            }
            index++;
        }
        while (i < size1) {
            src[index] = array1[i];
            i++;
            index++;
        }
        while (j < size2) {
            src[index] = array2[j];
            j++;
            index++;
        }
    }

    public static void main(String arg[]) {
        int[] src = {2, 9, 3, 7, 5, 0, 4};
        //int src[] = { 12, 11, 13, 5, 6, 7 };
        new MergeSort().sort(src);
        System.out.println(Arrays.toString(src));

    }
}
