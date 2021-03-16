package com.jobinesh.exercise.linkedlist;

import java.util.Stack;

/**
 * Given a singly linked list, determine if it is a palindrome.
 */
public class PalindromeLinkedList {
    public boolean isPalindrome(Node<String> head) {
        Node<String> slow = head;
        Node<String> fast = head;
        Stack<String> stack = new Stack();
        while (fast != null && fast.next != null) {
            stack.push(slow.value);
            slow = slow.next;
            fast = fast.next.next;

        }
        if(fast != null){
            slow = slow.next;
        }
        while (slow != null) {
            String poppedValue = stack.pop();
            if (!slow.value.equals(poppedValue)) {
                return false;
            }
            slow = slow.next;
        }
        return true;
    }

    public static void main(String[] args) {
        Node<String> linkedList = new Node<>("M");
        linkedList.next = new Node<>("A");
        linkedList.next.next = new Node<>("L");
        linkedList.next.next.next = new Node<>("L");
        linkedList.next.next.next.next = new Node<>("A");
        linkedList.next.next.next.next.next = new Node<>("M");
        Boolean isPalindrome = new PalindromeLinkedList().isPalindrome(linkedList);
        System.out.println("isPalindrome: " + isPalindrome);
    }
}
