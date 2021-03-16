package com.jobinesh.exercise.linkedlist;

public class PartitionLinkedList {
    Node<Integer> partition1(Node<Integer> head, int value) {
        Node<Integer> pointer = head;
        Node<Integer> headPointer = head;
        Node<Integer> prev = null;
        while (pointer != null) {
            if (pointer.value < value && headPointer != pointer) {
                Node tmp = pointer;
                pointer= pointer.next;
                tmp.next=headPointer;
                headPointer=tmp;
                if(prev!=null){
                    prev.next=pointer;
                }
            }else{
                prev=pointer;
                pointer= pointer.next;
            }
        }
        return headPointer;
    }

    Node<Integer> partition(Node<Integer> head, int value) {
        Node<Integer> headPointer = head;
        Node<Integer> tailPointer = head;
        Node<Integer> pointer = head;
        while (pointer != null) {
            Node next = pointer.next;
            if (pointer.value < value) {
                pointer.next=headPointer;
                headPointer=pointer;
            }else{
                tailPointer.next=pointer;
                tailPointer=pointer;
            }
            pointer=next;
        }
        tailPointer.next=null;
        return headPointer;
    }

    public static void main(String[] args) {
        Node<Integer> linkedList = new Node<>(1);
        linkedList.next = new Node<>(12);
        linkedList.next.next = new Node<>(3);
        linkedList.next.next.next = new Node<>(4);
        linkedList.next.next.next.next = new Node<>(15);
        linkedList.next.next.next.next.next = new Node<>(6);
        linkedList.next.next.next.next.next.next = new Node<>(17);
        NodeUtil.printList(linkedList);
        System.out.println("--------------");
        PartitionLinkedList partitionLinkedList = new PartitionLinkedList();
        Node partionedList = partitionLinkedList.partition(linkedList, 6);
        NodeUtil.printList(partionedList);
    }
}
