package com.jobinesh.exercise.stack;

import java.util.Arrays;

/**
 * How to efficiently implement k stacks in a single array?
 */
public class KStack {
    int totalStacks;
    int size;
    final int[] topIndex;
    final int[] nextIndex;
    final int[] stack;
    int freeIndex = 0;

    public KStack(int totalStacks, int size) {
        this.totalStacks = totalStacks;
        this.size = size;
        stack = new int[size];
        topIndex = new int[totalStacks];
        nextIndex = new int[size];
        for (int i = 0; i < size - 1; i++) {
            nextIndex[i] = i + 1;
        }
        nextIndex[size - 1] = -1;
        for (int i = 0; i < totalStacks; i++) {
            topIndex[i] = -1;
        }
    }

    public void push(int value,int stackNum) {
        if (freeIndex == -1) {
            throw new ArrayIndexOutOfBoundsException("Stack limit reached");
        }
        int index = freeIndex;
        stack[index] = value;
        freeIndex = nextIndex[index];
        nextIndex[index] = topIndex[stackNum];
        topIndex[stackNum] = index;

    }

    public int pop(int stackNum) {
        if((topIndex[stackNum] == -1)){
            throw new ArrayIndexOutOfBoundsException("Stack is empty");
        }
        int index = topIndex[stackNum];
        freeIndex = index;
        topIndex[stackNum] = nextIndex[index];
        return stack[index];
    }

    @Override
    public String toString() {
        return "KStack{" +
                "totalStacks=" + totalStacks +
                ", size=" + size +
                ", topIndex=" + Arrays.toString(topIndex) +
                ", nextIndex=" + Arrays.toString(nextIndex) +
                ", stack=" + Arrays.toString(stack) +
                ", freeIndex=" + freeIndex +
                '}';
    }

    public static void main(String[] args) {
        int k = 3, n = 10;

        KStack ks = new KStack(k, n);

        ks.push(15, 2);
        ks.push(45, 2);

        // Let us put some items in stack number 1
        ks.push(17, 1);
        ks.push(49, 1);
        ks.push(39, 1);

        // Let us put some items in stack number 0
        ks.push(11, 0);
        ks.push(9, 0);
        ks.push(7, 0);
        System.out.println(" Stack "+ ks.toString());
        System.out.println("Popped element from stack 2 is " + ks.pop(2));
        System.out.println("Popped element from stack 1 is " + ks.pop(1));
        System.out.println("Popped element from stack 0 is " + ks.pop(0));

    }
}
