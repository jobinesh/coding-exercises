package com.jobinesh.exercise.dp;

public class FlowerPlant {
    public int maxNutrient(int[] nutritients) {
        int a = 0;
        int b = 0;
        for (int i = 0; i < nutritients.length; i++) {
            int max = Math.max(a+nutritients[i], b);
            a =b;
            b= max;
            System.out.println( "a:"+a +  "b:"+b);
        }
        return b;
    }

    public static void main(String[] args) {
        System.out.println(new FlowerPlant().maxNutrient(new int[]{8, 10, 9, 6, 6, 8}));
    }
}
