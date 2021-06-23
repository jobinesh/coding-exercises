package com.jobinesh.exercise.search;

public class BinarySearch {

    public int search(int[] src, int value) {
        return bSearch(src, value, 0, src.length - 1);
    }

    private int bSearch(int[] src, int value, int beg, int last) {
        if (beg > last) {
            return -1;
        }
        int mid = (beg + last) / 2;
        System.out.println("beg: "+beg+ " mid: "+mid +" end: "+last);
        System.out.println("src[mid]:"+src[mid]);
        if (src[mid] == value) {
            return mid;
        } else if (src[mid] > value) {
            return bSearch(src, value, beg, mid - 1);
        } else {
            return bSearch(src, value, mid + 1, last);
        }
    }

    public static void main(String[] args) {
        System.out.println(new BinarySearch().search(new int[]{3, 4, 5, 6, 7,10,90}, 110));
    }
}
