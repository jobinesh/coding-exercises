package com.jobinesh.exercise.linkedlist;

import java.math.BigDecimal;

public class InsertionSortDoublyLinkedList<T> {
    public void sort(Node<T> node) {
       Node<T> nodeI = node.next;
       while(nodeI != null){
           Node<T> nodeJ=nodeI.prev;
           while(nodeJ != null && compare(nodeJ.value, nodeI.value )>0){
               //exchange nodes
               Node tmpNodeJ=nodeJ;
               Node tmpNodeI= nodeI;
               if(nodeJ.prev != null) {
                   nodeJ.prev.next = tmpNodeI;
               }
               tmpNodeI.prev=nodeJ.prev;
               tmpNodeI.next=nodeJ;
               nodeJ.prev=tmpNodeI;
               nodeJ.next=nodeI.next;
               nodeJ=tmpNodeJ;
               nodeJ=nodeJ.prev;

           }
           nodeI=nodeI.next;
       }

    }

    private int compare(T arg1, T arg2) {
        if (arg1 instanceof Number) {
            BigDecimal bg1 = new BigDecimal(((Number) arg1).doubleValue());
            BigDecimal bg2 = new BigDecimal(((Number) arg2).doubleValue());
            return bg1.compareTo(bg2);
        } else {
            throw new UnsupportedOperationException(String.format("The comapre op is not suported for type % ", arg1.getClass()));
        }
    }

    public static void main(String[] args) {
        Node<Integer> head = new Node<>(100);
        head.next = new Node<>(20);
        head.next.prev = head;
        head.next.next = new Node<>(10);
        head.next.next.next = new Node<>(90);
        head.next.next.prev = head.next;
        InsertionSortDoublyLinkedList<Integer> sorter = new InsertionSortDoublyLinkedList<>();
        NodeUtil.printList(head);
        sorter.sort(head);
        NodeUtil.printList(head);
    }
}
