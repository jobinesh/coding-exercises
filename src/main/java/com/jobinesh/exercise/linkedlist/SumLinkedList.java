package com.jobinesh.exercise.linkedlist;

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 */
public class SumLinkedList {

    public Node add(Node<Integer> num1, Node<Integer> num2) {
        Node<Integer> sum = null;
        Node<Integer> sumPointer = null;
        int reminder = 0;
        while (num1 != null && num2 != null) {
            int currentSum = num1.value + num2.value + reminder;
            if (currentSum >= 10) {
                reminder = currentSum % 10;
                currentSum = currentSum / 10;
            }else{
                reminder=0;
            }
            Node curentSumNode = new Node(currentSum);
            if (sumPointer != null) {
                sumPointer.next = curentSumNode;
            }else {
                sum = curentSumNode;
            }
            sumPointer=curentSumNode;
            num1 = num1.next;
            num2 = num2.next;
        }
        while (num1 != null) {
            int currentSum = num1.value + reminder;
            if (currentSum >= 10) {
                reminder = currentSum % 10;
                currentSum = currentSum / 10;
            }else{
                reminder=0;
            }
            Node curentSumNode = new Node(currentSum);
            if (sumPointer != null) {
                sumPointer.next = curentSumNode;
            }else {
                sum = curentSumNode;
            }
            sumPointer=curentSumNode;
            num1 = num1.next;
        }
        while (num2 != null) {
            int currentSum = num2.value + reminder;
            if (currentSum >= 10) {
                reminder = currentSum % 10;
                currentSum = currentSum / 10;
            }else{
                reminder=0;
            }
            Node curentSumNode = new Node(currentSum);
            if (sumPointer != null) {
                sumPointer.next = curentSumNode;
            }else {
                sum = curentSumNode;
            }
            sumPointer=curentSumNode;
            num2 = num2.next;
        }
        if (reminder > 0) {

            Node curentSumNode = new Node(reminder);
            if (sumPointer != null) {
                sumPointer.next = curentSumNode;
            }else {
                sum = curentSumNode;
            }
        }
        return sum;
    }

    private Node buildSumNode(int num1, int num2, int reminder) {
        int currentSum = num1 + num2 + reminder;
        Node currentSumNode = new Node(currentSum);
        return currentSumNode;
    }

    public static void main(String[] args) {
        String s= "a"+9;
        System.out.println(s);
        Node<Integer> num1List = new Node<>(1);
        num1List.next = new Node<>(2);
        num1List.next.next = new Node<>(3);
        num1List.next.next.next = new Node<>(4);
        NodeUtil.printList(num1List);
        System.out.println("----------------------");
        Node<Integer> num2List = new Node<>(1);
        num2List.next = new Node<>(2);
        num2List.next.next = new Node<>(3);
        num2List.next.next.next = new Node<>(4);
        NodeUtil.printList(num2List);
        System.out.println("----------------------");
        Node sum = new SumLinkedList().add(num1List, num2List);
        NodeUtil.printList(sum);
    }
}
