package com.jobinesh.exercise.linkedlist;

public class NodeUtil {// Function to print the linked list

    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
    }
}