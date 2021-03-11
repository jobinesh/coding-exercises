package com.jobinesh.exercise.linkedlist;

class Node<T> {
    T value;
    Node<T> next;

    public Node(T value) {
        this.value = value;
    }
}

/*
 * Write a routine for detecting if a linked list contains a loop.
 * It should return true if there is a loop or circular reference
 * in the list, and false otherwise.
 *
 * You may start with the following skeleton, then fill in the
 * isLooped() method to match the documented behavior.
 */
public class CircularLinkedList<T> {
    /**
     * The method indicates whether or not a linked list contains a circular
     * reference.
     *
     * @param List to check
     * @return true if the list contains a circular reference, false otherwise
     */
    public boolean isLooped(Node<T> head) {

        ///////////////////////
        // Fill this in here //
        ///////////////////////
        Node<T> slow = head;
        Node<T> fast = head;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                removeLoop(head, slow);
                return true;
            }
        }

        return false;
    }

    /**
     * 1) Detect Loop using Floyd’s Cycle detection algo and get the pointer to a loop
     * node.
     * 2) Count the number of nodes in loop. Let the count be k.
     * 3) Fix one pointer to the head and another to kth node from head.
     * 4) Move both pointers at the same pace, they will meet at loop starting node.
     * 5) Get pointer to the last node of loop and make next of it as NULL.
     */
    private void removeLoop(Node<T> rootNode, Node<T> loopStartNode) {
        Node<T> headNode = rootNode;
        Node<T> tailsNode = loopStartNode;
        while (headNode.next != loopStartNode.next) {
            headNode = headNode.next;
            loopStartNode = loopStartNode.next;
        }
        loopStartNode.next = null;
    }

    public static void main(String[] unused) {
        CircularLinkedList<Integer> detector = new CircularLinkedList<>();

        // Some sample lists to test with... customize during your test.
        Node<Integer> list1 = null;
        Node<Integer> list2 = new Node<>(5);
        list2.next = new Node<>(12);
        list2.next.next = new Node<>(7);
        list2.next.next.next = new Node<>(-512);
        // Uncomment and adjust the below to prove the solution
        list2.next.next.next.next = list2.next;

        if (detector.isLooped(list1)) {
            System.out.println("list1 is looped");
        }
        if (detector.isLooped(list2)) {
            System.out.println("list2 is looped");
        }
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
