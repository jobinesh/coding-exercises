package com.jobinesh.exercise.sort;

import org.junit.runner.JUnitCore;

import java.util.Arrays;

public class BubbleSort {
    public void sort(int[] src){
        for(int i=0;i<src.length-1;i++){
            for(int j=0;j<src.length-1-i;j++){
                if( src[j]>src[j+1]){
                    int tmp= src[j];
                    src[j]=src[j+1];
                    src[j+1]=tmp;
                }
            }
        }
    }
    public static void main(String arg[]){
        int[] src={2,9,3,7,5,0,4};
        new BubbleSort().sort(src);
        System.out.println(Arrays.toString( src));
       // JUnitCore.main(BubbleSort.class.getName());
    }
}
