package com.jobinesh.exercise.array;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 * <p>
 * Merge all the linked-lists into one sorted linked-list and return it.
 */
public class MergingSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {

        ListNode merged = merge(lists);
        return merged;
    }

    private ListNode merge(ListNode[] lists) {
        ListNode current = null;
        ListNode head = null;
        ListNode nextNode = null;
        while ((current = smallest(lists)) != null) {
            //System.out.println("merge() :: current :: " + current);
            if (head == null) {
                head = current;
                nextNode = current;
            } else {
                nextNode.next = current;
                nextNode = nextNode.next;
            }
        }
        return head;
    }

    private ListNode smallest(ListNode[] lists) {
        ListNode smallest = null;
        ListNode node = null;
        int index=-1;
        for (int i = 0; i < lists.length; i++) {
           // System.out.println("smallest() :: current :: " + node);
            if (lists[i] == null) {
                continue;
            }
            if (smallest == null || smallest.val > lists[i].val) {
                node = lists[i];
                smallest = new ListNode(node.val);
                index=i;
            }
        }
        if(smallest != null) {
            lists[index] = node.next;;
        }
        return smallest;
    }

    public static void main(String args[]) {
        ListNode node1 = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode node2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode node3 = new ListNode(2, new ListNode(6));

        ListNode[] nodes = new ListNode[]{node1, node2, node3};
        ListNode result = new MergingSortedLists().mergeKLists(nodes);
        System.out.println("Result :" + result);
        result = new MergingSortedLists().mergeKLists(nodes = new ListNode[]{});
        System.out.println("Result :" + result);

    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}
