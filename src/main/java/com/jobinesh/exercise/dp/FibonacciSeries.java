package com.jobinesh.exercise.dp;

public class FibonacciSeries {
    public int fibonacci(int num) {
        if (num == 0 || num == 1) {
            return num;
        }
        int sum = 0;
        int part2 = 0;
        int part1 = 1;
        for (int i = 2; i <= num; i++) {
            sum = part1 + part2;
            part2 = part1;
            part1 = sum;
        }
        return sum;
    }

    public static void main(String[] args) {
        int sum = new FibonacciSeries().fibonacci(10);
        System.out.println( sum);
    }
}
