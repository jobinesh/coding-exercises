package com.jobinesh.exercise.stack;

import java.util.Arrays;

class StackImpl {
    private Integer[] stackArray;
    private int index = -1;
    private static final int DEFAULT_SIZE = 36;

    public StackImpl() {
        stackArray = new Integer[DEFAULT_SIZE];

    }

    public StackImpl(int size) {
        stackArray = new Integer[size];
    }

    public void push(Integer value) {
        if (index+1 == stackArray.length) {
            throw new IndexOutOfBoundsException("Size exceeds " + stackArray.length);
        }
        index++;
        stackArray[index] = value;

    }

    public Integer peek() {
        if (index >= 0)
            return stackArray[index];
        else
            return null;
    }

    public Integer pop() {
        Integer obj = stackArray[index];
        if (obj == null) {
            throw new IllegalStateException("Stack is empty");
        }
        stackArray[index] = null;
        index--;
        return obj;
    }

    public boolean isEmpty() {
        if (index < 0) {
            return true;
        }
        return false;
    }

    public boolean isFull() {
        if (index+1 == stackArray.length) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "StackImpl{" +
                "stackArray=" + Arrays.toString(stackArray) +
                ", index=" + index +
                '}';
    }
}
