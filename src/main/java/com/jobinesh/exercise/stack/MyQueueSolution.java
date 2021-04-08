package com.jobinesh.exercise.stack;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.JUnitCore;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * implement queue using two stacks
 */
class QueueOnStack<T> {
    private ArrayDeque<T> newElemStack;
    private ArrayDeque<T> oldElemStack;

    public QueueOnStack() {
        newElemStack = new ArrayDeque<>();
        oldElemStack = new ArrayDeque<>();
    }

    public void push(T item) {
        newElemStack.push(item);
    }

    public void transfer() {
        while(!newElemStack.isEmpty()){
            oldElemStack.push(newElemStack.pop());
        }
    }

    public T pop() {
        transfer();
        if (oldElemStack.isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return oldElemStack.pop();
    }

    public int size() {
        return newElemStack.size() + oldElemStack.size();
    }
}


public class MyQueueSolution {
    @Test
    public void testQueuePush(){
        QueueOnStack<String> queueOnStack = new QueueOnStack<>();
        queueOnStack.push("A");
        queueOnStack.push("B");
        queueOnStack.push("C");
        Assert.assertEquals("A", queueOnStack.pop());
    }
    @Test
    public void testQueuePop(){
        QueueOnStack<String> queueOnStack = new QueueOnStack<>();
        queueOnStack.push("A");
        queueOnStack.push("B");
        queueOnStack.push("C");
        queueOnStack.pop();
        queueOnStack.pop();
        Assert.assertEquals("C", queueOnStack.pop());
    }
    @Test
    public void testQueueSize(){
        QueueOnStack<String> queueOnStack = new QueueOnStack<>();
        queueOnStack.push("A");
        queueOnStack.push("B");
        queueOnStack.push("C");
        queueOnStack.pop();
        Assert.assertEquals(2, queueOnStack.size());
    }
    @Test(expected=NoSuchElementException.class)
    public void testQueueNoElementError(){
        QueueOnStack<String> queueOnStack = new QueueOnStack<>();
        queueOnStack.push("A");
        queueOnStack.push("B");
        queueOnStack.push("C");
        queueOnStack.pop();
        queueOnStack.pop();
        queueOnStack.pop();
        queueOnStack.pop();
    }
    public static void main() {
        JUnitCore.main(MyQueueSolution.class.getName());
    }
}