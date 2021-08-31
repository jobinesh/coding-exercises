package com.jobinesh.exercise.cache;

import java.util.HashMap;
import java.util.Map;


class EasyCacheRefLinkedList {
    CacheNode head = new CacheNode(null, null);
    CacheNode tail = new CacheNode(null, null);

    public EasyCacheRefLinkedList() {
        head.setNext(tail);
        tail.setPrev(head);
    }

    void add(CacheNode node) {
        CacheNode next = head.getNext();
        head.setNext(node);
        node.setNext(next);
        node.setPrev(head);
        next.setPrev(node);
    }

    CacheNode removeTail() {
        if (head.getNext() == tail) {
            return null;
        }
        CacheNode node = tail.getPrev();
        CacheNode prev = node.getPrev();
        prev.setNext(tail);
        tail.setPrev(prev);
        return node;

    }

    void moveFront(CacheNode node) {

        if (head.getNext() == tail) {
            return;
        }
        CacheNode current = head.getNext();
        while (current != tail) {
            if (current.getKey().equals(node.getKey()) && current.getValue().equals(node.getValue())) {
                CacheNode prev = current.getPrev();
                CacheNode next = current.getNext();
                prev.setNext(next);
                next.setPrev(prev);

                next = head.getNext();
                head.setNext(current);
                next.setPrev(head);
                current.setNext(next);
            }
            current = current.getNext();
        }
    }

    boolean remove(CacheNode node) {

        if (head.getNext() == tail) {
            return false;
        }
        CacheNode current = head.getNext();
        while (current != tail) {
            if (current.getKey().equals(node.getKey()) && current.getValue().equals(node.getValue())) {
                CacheNode prev = current.getPrev();
                CacheNode next = current.getNext();
                prev.setNext(next);
                next.setPrev(prev);
                current.setNext(null);
                current.setPrev(null);
                return true;
            }
            current = current.getNext();
        }
        return false;
    }


}

public class EasyLRUCache {
    private int capacity;
    private Map<Integer, CacheNode> cacheNodeMap = new HashMap<>();
    EasyCacheRefLinkedList refLink = new EasyCacheRefLinkedList();

    public EasyLRUCache(int capacity) {
        this.capacity = capacity;
    }

    public Integer get(Integer key) {
        CacheNode node = cacheNodeMap.get(key);
        if (node != null) {
            refLink.moveFront(node);
            return node.getValue();
        } else {
            return null;
        }
    }

    public void put(Integer key, Integer value) {
        if (cacheNodeMap.containsKey(key)) {
            CacheNode node = cacheNodeMap.get(key);
            node.setValue(value);
            refLink.moveFront(node);
        } else {
            if (cacheNodeMap.size() == capacity) {
                CacheNode node = refLink.removeTail();
                cacheNodeMap.remove(node.getKey());
            }
            CacheNode newNode = new CacheNode(key, value);
            cacheNodeMap.put(key, newNode);
            refLink.add(newNode);
        }
    }

    public boolean remove(Integer key) {
        CacheNode node = cacheNodeMap.remove(key);
        if (node != null) {
            refLink.remove(node);
        }
        if (node == null) {
            return false;
        } else {
            return true;
        }
    }

    public static void main(String[] args) {
        EasyLRUCache lRUCache = new EasyLRUCache(2);
        lRUCache.put(1, 1); // cache is {1=1}
        System.out.println("==1==");
        lRUCache.put(2, 2); // cache is {1=1, 2=2}
        System.out.println("==2==");
        System.out.println(lRUCache.get(1));    // return 1
        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        System.out.println("==3==");
        System.out.println(lRUCache.get(2));    // returns -1 (not found)
        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        System.out.println(lRUCache.get(1));    // return -1 (not found)
        System.out.println(lRUCache.get(3));    // return 3
        System.out.println(lRUCache.get(4));    // return 4
    }
}
