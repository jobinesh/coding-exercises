package com.jobinesh.exercise.array;

import java.util.Arrays;

/**
 * Given an image represented by an NxN matrix,
 * where each pixel in the image is 4 bytes, write a method to rotate the image by 90 degrees.
 */
public class MatrixRotation {
    public void rotate(int[][] matrix){
        if(matrix == null || matrix.length==0 || matrix[0] == null || matrix.length != matrix[0].length ){
            return;
        }
        int layer= matrix[0].length/2;
        int length = matrix[0].length;

        for(int i=0;i<layer;i++ ){
            int start=i;
            int end=length-1-i;

            for(int j=i;j<end;j++){
                int offset=j-i;
                int tmp=matrix[start][j];
                matrix[start][j]=matrix[end-offset][start];
                matrix[end-offset][start]=matrix[end][end-offset];
                matrix[end][end-offset]=matrix[j][end];
                matrix[j][end]=tmp;
            }
        }
    }

    public static void main(String args[]){
        int[][] matrix = { { 3, 2, 1, 7 },
                { 9, 11, 5, 4 },
                { 6, 0, 13, 17 },
                { 7, 21, 14, 15 } };
        System.out.println(Arrays.deepToString(matrix));
        System.out.println("---------------------");
        new MatrixRotation().rotate( matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}
