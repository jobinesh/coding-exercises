package com.jobinesh.exercise.cache;

import java.util.HashMap;
import java.util.Objects;

/**
 * Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
 * <p>
 * Implement the LRUCache class:
 * <p>
 * LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
 * int get(int key) Return the value of the key if the key exists, otherwise return -1.
 * void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
 * The functions get and put must each run in O(1) average time complexity
 */
class Node<K,V> {
    K key;
    V value;
    Node prev;
    Node next;

    public Node() {
    }

    public Node(K key,V value) {
        this.key=key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }



    public V getValue() {
        return value;
    }


    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node<?, ?> node = (Node<?, ?>) o;
        return Objects.equals(key, node.key) &&
                Objects.equals(value, node.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value);
    }
}

class LRURefLinkedList<K,V> {
    Node<K,V> head;
    Node<K,V> tail;
    int count = 0;

    public void addNodeToHead(Node<K,V> node) {
        if (head == null) {
            head = node;
            tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
        count++;
    }

    public Node<K,V> removeNodeFromTail() {
        if(tail== head){
            return tail;
        }
        Node<K,V> removedTail = null;
        if (tail != null) {
            removedTail = tail;
            tail = tail.prev;
            tail.next = null;
        }
        count--;
        return removedTail;
    }

    public void moveToHead(Node<K,V> node) {
        if (head == null) {
            head = node;
            tail = node;
        }
        if(tail== head){
            return ;
        }
        Node<K,V> current = head;
        while (current != null) {
            if (current.equals(node)) {
                Node tmpNext = current.next;
                Node tmpPrev = current.prev;

                if(tmpNext == null && tmpPrev !=null){
                    tail=tmpPrev;
                }
                current.next = head;
                head.prev = current;
                head = current;
                head.prev = null;
                if (tmpPrev != null) {
                    tmpPrev.next = tmpNext;
                }
                if (tmpNext != null) {
                    tmpNext.prev = tmpPrev;
                }

                break;
            }
            current = current.next;
        }
    }
}

public class LRUCache {
    int capacity = 0;
    LRURefLinkedList<Integer,Integer> keyRefList = new LRURefLinkedList();
    HashMap<Integer, Node<Integer,Integer>> cacheMap = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        Node<Integer,Integer> value = cacheMap.get(key);
        if (value != null) {
            keyRefList.moveToHead(value);
            return value.getValue();
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        if (!cacheMap.containsKey(key)) {
            if (cacheMap.size() == capacity) {
                Node<Integer,Integer> refKey = keyRefList.removeNodeFromTail();
                cacheMap.remove(refKey.key,refKey);
            }
        }
        Node<Integer,Integer> node = new Node<>(key,value);
        cacheMap.put(key, node);
        keyRefList.addNodeToHead(node);
    }

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // cache is {1=1}
        lRUCache.put(2, 2); // cache is {1=1, 2=2}
        printIt(lRUCache.get(1));    // return 1
        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        printIt(lRUCache.get(2));    // returns -1 (not found)
        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        printIt(lRUCache.get(1));    // return -1 (not found)
        printIt(lRUCache.get(3));    // return 3
        printIt(lRUCache.get(4));    // return 4
    }

    public static void printIt(Integer value) {
        System.out.println(value);
    }
}
