package com.jobinesh.exercise.sort;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.JUnitCore;

import java.util.Arrays;

public class InsertionSort {

    public void sort(int[] src){
      for(int i=1;i<src.length;i++){
          int current = src[i];
          int j= i-1;
          while(j>=0 && src[j]>current){
              src[j+1]=src[j];
              j--;
          }
          src[j+1]=current;
      }
    }
    public void _sort(int[] src) {
        for (int i = 1; i < src.length; i++) {
            int j = i;
            int current = src[j-1];
            while (j >= 1 && src[j-1] > src[j]) {
                int tmp = src[j-1];
                src[j-1] = src[j];
                src[j] = tmp;
                j--;
            }
        }
    }

    @Test
    public void testSimpleEquals(){
        int[] src={2,9,3,7,5,0,4};
        new InsertionSort().sort(src);
        Assert.assertArrayEquals( new int[]{0, 2, 3, 4, 5, 7, 9}, src);
    }
    @Test
    public void testEmptyArrayEquals(){
        int[] src={};
        new InsertionSort().sort(src);
        Assert.assertArrayEquals( new int[]{}, src);
    }
    @Test
    public void testSameElementsArrayEquals(){
        int[] src={1,1,1};
        new InsertionSort().sort(src);
        Assert.assertArrayEquals( new int[]{1,1,1}, src);
    }
    public static void main(String arg[]){
        int[] src={2,9,3,7,5,0,4};
        new InsertionSort().sort(src);
        System.out.println(Arrays.toString( src));
        JUnitCore.main(InsertionSort.class.getName());
    }
}
