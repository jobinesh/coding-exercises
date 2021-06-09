package com.jobinesh.exercise.sort;

import com.jobinesh.exercise.stream.ZipperSolution;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.JUnitCore;

import java.util.Arrays;

public class SelectionSort {
    public void sort(int[] src){
        for(int i=0;i<src.length-1;i++){
            int minIndex =i;
            for(int j=i+1;j<src.length;j++){
                if(src[j]<src[minIndex]){
                    minIndex =j;
                }
            }
            System.out.println("i "+ i+ " minIndex:"+minIndex );
            if(i!=minIndex){

                int tmp=src[i];
                src[i]=src[minIndex];
                src[minIndex]=tmp;
            }
        }
    }
    @Test
    public void testSimpleSort(){
        int[] src={2,9,3,7,5,0,4};
        new SelectionSort().sort(src);
        Assert.assertArrayEquals(new int[] {0, 2, 3, 4, 5, 7, 9},src );
    }
    @Test
    public void testEmptyArraySort(){
        int[] src={};
        new SelectionSort().sort(src);
        Assert.assertArrayEquals(new int[] {},src );
    }
    @Test
    public void testNonHappyPathSort(){
        int[] src={5,6};
        new SelectionSort().sort(src);
        Assert.assertNotEquals(new int[] {5,6},src );
    }
    public static void main(String arg[]){
        //int[] src={2,9,3,7,5,0,4};
        //new SelectionSort().sort(src);
       // System.out.println(Arrays.toString( src));
        JUnitCore.main(SelectionSort.class.getName());
    }
}
