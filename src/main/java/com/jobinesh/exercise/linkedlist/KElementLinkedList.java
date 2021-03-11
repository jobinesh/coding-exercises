package com.jobinesh.exercise.linkedlist;

/**
 * The following function is trying to find the Kth to last element of a singly linked list.
 */
public class KElementLinkedList {

    public void removeMiddle(Node head) {
        Node pointer1 = head;
        Node pointer2 = head;
        Node prevToMiddle = head;
        int total = 1;
        while (pointer1 != null) {
            System.out.println( total+" : "+pointer2.value );
            if (total%2==0) {
                pointer1 = pointer1.next;
            } else {
                pointer1 = pointer1.next;
                if(total>2) {
                    prevToMiddle = pointer2;
                    pointer2 = pointer2.next;
                }
            }

            total++;
        }
        System.out.println(pointer2.value );
        prevToMiddle.next= pointer2.next;

    }

    public Node getElement(Node head, int k) {
        Node pointer1 = head;
        Node pointer2 = head;
        int cnt = 0;
        while (pointer1 != null) {
            if (cnt < k) {
                pointer1 = pointer1.next;
            } else {
                pointer1 = pointer1.next;
                pointer2 = pointer2.next;
            }
            cnt++;
        }
        if (cnt < k) {
            return null;
        }
        return pointer2;
    }

    public static void main(String[] args) {
        KElementLinkedList list = new KElementLinkedList();
        // Some sample lists to test with... customize during your test.
        Node<Integer> kList = new Node<>(1);
        kList.next = new Node<>(2);
        kList.next.next = new Node<>(3);
        kList.next.next.next = new Node<>(4);
        kList.next.next.next.next = new Node<>(5);
        kList.next.next.next.next.next = new Node<>(6);
        kList.next.next.next.next.next.next = new Node<>(7);
       // kList.next.next.next.next.next.next.next = new Node<>(8);
        //Node kNode = list.getElement(kList, 6);
        list.removeMiddle(kList);
        DuplicateLinkedList.printList(kList);
    }
}
