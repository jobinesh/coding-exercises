package com.jobinesh.exercise.array;

public class ArrayRotation {
    public static void rotateArray(int[] arr){

        // Write - Your - Code
        int last=arr[arr.length-1];
        int prev=arr[0];
        for(int i=0;i<arr.length-1;i++){
            int tmp =arr[i+1];
            arr[i+1]=prev;
            prev=tmp;
        }
        arr[0]=last;
    }
    public static void main(String args[]) {

        int[] arr = {3, 6, 1, 8, 4, 2};

        System.out.print("Array before rotation: ");
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        rotateArray(arr);

        System.out.println("Array after rotation: ");
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        rotateArray(arr);

        System.out.println("Array after rotation: ");
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        rotateArray(arr);

        System.out.println("Array after rotation: ");
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
