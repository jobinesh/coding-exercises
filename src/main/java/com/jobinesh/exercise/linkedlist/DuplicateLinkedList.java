package com.jobinesh.exercise.linkedlist;

/**
 * Write a removeDuplicates() function which takes a list and deletes any duplicate nodes from the list.
 * The list is not sorted.
 * For example if the linked list is 12->11->12->21->41->43->21
 * then removeDuplicates() should convert the list to 12->11->21->41->43.
 */
public class DuplicateLinkedList {

    public void removeDuplicates(Node head) {
        Node pointer1 = head;
        while (pointer1 != null) {
            Node pointer2 = pointer1;
             while (pointer2.next != null) {
               if(pointer2.next.value==pointer1.value){
                   pointer2.next = pointer2.next.next;
               }else {
                   pointer2 = pointer2.next;
               }
            }
            pointer1 = pointer1.next;
        }

    }

    public static void main(String[] args) {
        DuplicateLinkedList dupliRemover = new DuplicateLinkedList();
        // Some sample lists to test with... customize during your test.
        Node<Integer> list1 = null;
        Node<Integer> list2 = new Node<>(5);
        list2.next = new Node<>(12);
        list2.next.next = new Node<>(7);
        list2.next.next.next = new Node<>(-512);
        list2.next.next.next.next = new Node<>(7);
        list2.next.next.next.next.next = new Node<>(5);
        list2.next.next.next.next.next.next = new Node<>(5);

        printList(list2);
        System.out.println("-------------------");
        dupliRemover.removeDuplicates(list2);
        printList(list2);
    }

    // Function to print the linked list
    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
    }
}
