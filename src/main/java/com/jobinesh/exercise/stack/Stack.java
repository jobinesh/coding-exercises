package com.jobinesh.exercise.stack;

/*
Design a Data Structure SpecialStack that supports all the stack operations like push(), pop(), isEmpty(),
isFull() and an additional operation getMin() which should return minimum element from the SpecialStack.
 */
public class Stack {
    private static final int DEFAULT_SIZE = 36;
    StackImpl stack;
    StackImpl minValues;

    public Stack() {
        stack = new StackImpl(DEFAULT_SIZE);
        minValues = new StackImpl(DEFAULT_SIZE);
    }

    @Override
    public String toString() {
        return "Stack{" +
                "stack=" + stack +
                '}';
    }

    public Stack(int size) {

        stack = new StackImpl(size);
        minValues = new StackImpl(size);
    }

    private void setMin(Integer value) {
        Integer min = minValues.peek();
        if (min == null || min.compareTo(value) >= 0) {
            minValues.push(value);
        }
    }

    public void push(Integer value) {
        stack.push(value);
        setMin(value);
    }

    public Integer pop() {
        Integer result = stack.pop();
        Integer min = minValues.peek();
        if (result.compareTo(min) == 0) {
            minValues.pop();
        }
        return result;
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public boolean isFull() {
        return stack.isFull();
    }

    public Integer getMin() {
        return minValues.peek();
    }

    public static void main(String args[]) {
        Stack s = new Stack();
        s.push(3);
        s.push(5);
        log(s.getMin());
        s.push(2);
        s.push(2);
        log( s);
        s.push(2);
        s.push(1);
        log(s.getMin());
        log(s.pop());
        log(s.pop());
        log(s.getMin());
        log(s.pop());
        log( s);
    }
    static void log(Object value){
        System.out.println( value);
    }
}
