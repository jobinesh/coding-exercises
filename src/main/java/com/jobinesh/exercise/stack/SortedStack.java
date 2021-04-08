package com.jobinesh.exercise.stack;

import org.junit.Test;
import org.junit.runner.JUnitCore;

import java.util.Arrays;
import java.util.Stack;

/**
 * Write a program to sort a stack such that the smallest items are on the top. You can use an additional temporary stack,
 * but you may not copy the elements into any other data structure (such as an array). The stack supports the following
 * operations: push, pop, peek, and isEmpty.
 */
public class SortedStack {
    public static void main(String args) {
        JUnitCore.main(SortedStack.class.getName());
    }

    public void sort(Stack<Integer> stack) {
        Stack<Integer> tmpStack = new Stack<Integer>();
        while (!stack.isEmpty()) {
            int top = stack.pop();
            if (tmpStack.isEmpty()) {
                tmpStack.push(top);
            } else {
                while (!tmpStack.isEmpty() && tmpStack.peek() > top) {
                    stack.push(tmpStack.pop());
                }
                tmpStack.push(top);
            }
        }
        while (!tmpStack.isEmpty()) {
            stack.push(tmpStack.pop());
        }
    }

    @Test
    public void testSimpleSort() {
        Stack<Integer> inputstack = new Stack<>();
        inputstack.push(15);
        inputstack.push(5);
        inputstack.push(10);
        inputstack.push(8);
        Stack<Integer> outputstack = new Stack<>();
        outputstack.push(15);
        outputstack.push(10);
        outputstack.push(8);
        outputstack.push(5);
        System.out.println(Arrays.toString(inputstack.toArray()));
        SortedStack sortedStack = new SortedStack();
        sortedStack.sort(inputstack);
        System.out.println(Arrays.toString(inputstack.toArray()));

    }
}
