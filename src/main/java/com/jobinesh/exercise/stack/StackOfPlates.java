package com.jobinesh.exercise.stack;

import java.util.ArrayList;
import java.util.List;

/**
 * Imagine a (literal) stack of plates. If the stack gets too high, it might topple. Therefore, in real life, we would
 * likely start a new stack when the previous stack exceeds some threshold. Implement a data structure SetOfStacks
 * that mimics this. SetOfStacks should be composed of several stacks, and should create a new stack once the
 * previous one exceeds capacity. SetOfStacks.push() and SetOfStacks.pop() should behave identically to a
 * single stack (that is, pop() should return the same values as it would if there were just a single stack).
 * <p>
 * Input: capacity = 4 , push(1),push(2),push(2),pop,push(3),push(4),push(5)
 * <p>
 * Output: [[1,2,3,4],[5]]
 */
public class StackOfPlates {
    List<StackImpl> stacks = new ArrayList();

    public StackOfPlates() {
        StackImpl stack = new StackImpl(3);
        stacks.add(stack);
    }

    public void push(Integer value) {
        int index = getIndex();
        StackImpl stack = stacks.get(index);
        if (stack.isFull()) {
            stack = new StackImpl(3);
            stacks.add(stack);
        }
        stack.push(value);
    }

    private int getIndex() {

        return stacks.size() - 1;
    }

    public Integer pop() {
        int index = getIndex();
        StackImpl stack = stacks.get(index);
        Integer value = stack.pop();
        if (stack.isEmpty()) {
            stacks.remove(index);
        }
        return value;
    }

    public Integer popAtIndex(int index) {
        StackImpl stack = stacks.get(index);
        Integer value = stack.pop();
        if (stack.isEmpty()) {
            stacks.remove(index);
        }else{
            if(stacks.size()-1 != index) {
                resizeStacks(index);
            }
        }
        return value;
    }

    private void resizeStacks(int index) {
        for (int i = index; i < stacks.size(); i++) {

        }
    }

    @Override
    public String toString() {
        return "StackOfPlates{" +
                "stacks=" + stacks +
                '}';
    }

    public static void main(String args[]) {
        StackOfPlates s = new StackOfPlates();
        s.push(3);
        s.push(5);
        s.push(2);
        s.push(21);
        s.push(22);
        s.push(11);
        log(s);
        log(s.pop());
        log(s.pop());
        log(s.pop());
        log(s);
    }

    static void log(Object value) {
        System.out.println(value);
    }

}
