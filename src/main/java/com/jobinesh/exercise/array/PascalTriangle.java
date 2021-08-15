package com.jobinesh.exercise.array;

import java.util.Arrays;
import java.util.Scanner;

public class PascalTriangle {
    private int pascal[][] = null;

    public int[][] generatePascal(int row) {
        pascal = new int[row][row];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < row; j++) {
                pascal[i][j] = -1;
            }
        }
        for (int i = 0; i < row; i++) {
            int number = 1;
            for (int j = 0; j <= i; j++) {
                pascal[i][j] = number;
                number = number * (i - j) / (j + 1);

            }
        }
        return pascal;
    }

    public static void main(String[] args) {
        int[][] result = new PascalTriangle().generatePascal(5);
        System.out.println(Arrays.deepToString(result));
        /*
        try {
            BufferedReader br = new BufferedReader(new FileReader(""));
            String str=null;
            while(( str=br.readLine() )!= null){

            }
            Stream<String> consumer =Files.lines(Path.of(""));
            consumer.forEach(srr->System.out.println(srr));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
         */
    }

    public static void main1(String args[]) {
        int r, i, k, number = 1, j;
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter Number of Rows : ");
        r = scan.nextInt();

        for (i = 0; i < r; i++) {
            number = 1;
            for (j = 0; j <= i; j++) {
                System.out.print(number + " ");
                number = number * (i - j) / (j + 1);
            }
            System.out.println();
        }
    }
}
