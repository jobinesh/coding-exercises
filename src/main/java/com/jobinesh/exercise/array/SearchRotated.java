package com.jobinesh.exercise.array;


/*
Given a "rotated" sorted array of positive integers (no duplicates)

e.g. [1, 4, 7, 8, 11, 14] -> [8, 11, 14, 1, 4, 7]

Implement an algorithm to return the index of a given number in the array (or -1 if not found).
The algorithm has to be more efficient than a sequential search.

e.g. If rotated array is [8, 11, 14, 1, 4, 7]
x=1, return 3
x=11, return 1
x=13, return -1
*/

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.JUnitCore;


public class SearchRotated {

    public int search(int[] data, int number) {
        int low = 0;
        int high = data.length - 1;
        int pivot = findPivot(data,0, high);
        System.out.println("pivot"+pivot);
        int result = findByBinarySearch(data, 0, pivot, number);
        if (result == -1) {
            result = findByBinarySearch(data, pivot + 1, data.length - 1, number);
        }
        return result;
    }

    private int findPivot(int[] data, int low, int high) {
        if (low >= high) {
            return -1;
        }
        if (low == high) {
            return low;
        }

        int mid = (low + high) / 2;
        if (mid > low && data[mid] < data[mid - 1]) {
            return mid - 1;
        }
        if (mid < high && data[mid] > data[mid + 1]) {
            return mid;
        }
        if (data[low] >= data[high]) {
            return findPivot(data, low, mid - 1);
        }
        return findPivot(data, mid + 1, high);

    }

    private int findByBinarySearch(int[] data, int beg, int end, int value) {
        int low = beg;
        int high = end;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (data[mid] == value) {
                return mid;
            }
            if (data[mid] < value) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    @Test
    public void testFirst() {
        int[] inputData = {8, 11, 14, 1, 4, 7};
        int result = new SearchRotated().search(inputData, 8);
        Assert.assertEquals(0, result);
    }

    @Test
    public void testLast() {
        int[] inputData = {8, 11, 14, 1, 4, 7};
        int result = new SearchRotated().search(inputData, 7);
        Assert.assertEquals(5, result);
    }

    @Test
    public void testBeforePivot() {
        int[] inputData = {8, 11, 14, 1, 4, 7};
        int result = new SearchRotated().search(inputData, 11);
        Assert.assertEquals(1, result);
        result = new SearchRotated().search(inputData, 14);
        Assert.assertEquals(2, result);
    }

    @Test
    public void testAfterPivot() {
        int[] inputData = {8, 11, 14, 1, 4, 7};
        int result = new SearchRotated().search(inputData, 1);
        Assert.assertEquals(3, result);
        result = new SearchRotated().search(inputData, 4);
        Assert.assertEquals(4, result);
    }

    @Test

    public void testNotFound() {
        int[] inputData = {8, 11, 14, 1, 4, 7};
        int result = new SearchRotated().search(inputData, 10);
        Assert.assertEquals(-1, result);
    }

    public static void main(String[] args) {
        JUnitCore.main(SearchRotated.class.getName());
    }
}