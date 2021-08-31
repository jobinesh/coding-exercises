package com.jobinesh.exercise.cache;

import java.util.HashMap;
import java.util.Map;

class CacheNode {
    private Integer key;
    private Integer value;
    private CacheNode prev;
    private CacheNode next;

    CacheNode(Integer key, Integer value) {
        this.key = key;
        this.value = value;
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public CacheNode getPrev() {
        return prev;
    }

    public void setPrev(CacheNode prev) {
        this.prev = prev;
    }

    public CacheNode getNext() {
        return next;
    }

    public void setNext(CacheNode next) {
        this.next = next;
    }
}

class CacheRefLinkedList {
    CacheNode head;
    CacheNode tail;

    void add(CacheNode node) {
        if (head == null) {
            head = node;
            tail = node;
        }else{
            node.setNext(head);
            head.setPrev(node);
            head=node;
        }
    }

    CacheNode removeTail() {
        if (tail == null) {
            return null;
        }
        if (head == tail) {
            CacheNode node = tail;
            head = null;
            tail = null;
            return tail;
        } else {
            CacheNode node = tail;
            tail.getPrev().setNext(null);
            tail = tail.getPrev();
            node.setPrev(null);
            return node;
        }
    }

    void moveFront(CacheNode node) {

        if (head == tail
                && node.getValue().equals(head.getValue())
                && node.getKey().equals(head.getKey())) {
            return;
        }
        CacheNode current = head;
        while (current != null) {
            if (current.getKey().equals(node.getKey())
                    && current.getValue().equals(node.getValue())) {
                CacheNode prev = current.getPrev();
                CacheNode next = current.getNext();
                if (prev != null) {
                    prev.setNext(next);
                }
                if (next != null) {
                    next.setPrev(prev);
                }else{
                    tail=prev;
                }
                current.setNext(head);
                head.setPrev(current);
                current.setPrev(null);
                head = current;
                return;
            }
            current= current.getNext();
        }
    }

    boolean remove(CacheNode node) {
        CacheNode current = head;
        if (head == tail
                && node.getValue().equals(head.getValue())
                && node.getKey().equals(head.getKey())) {
            head = null;
            tail = null;
            return true;
        }
        while (current != null) {
            if (current.getKey().equals(node.getKey())
                    && current.getValue().equals(node.getValue())) {
                CacheNode prev = current.getPrev();
                CacheNode next = current.getNext();
                if (prev != null) {
                    prev.setNext(next);
                }
                if (next != null) {
                    next.setPrev(prev);
                }
                return true;
            }
            current=current.getNext();
        }
        return false;
    }
}

public class SimpleLRUCache {
    private int capacity;
    private Map<Integer, CacheNode> cacheNodeMap = new HashMap<>();
    CacheRefLinkedList refLink = new CacheRefLinkedList();

    public SimpleLRUCache(int capacity) {
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
        SimpleLRUCache lRUCache = new SimpleLRUCache(2);
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
