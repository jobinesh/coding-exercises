package com.jobinesh.exercise.map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.JUnitCore;

import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * 1. How does HashMap work ?
 * 1. Build a simple HashMap with put and get methods
 * 2. If value already exist for a key, the put() should replace the value, otherwise append it
 * 3. The get() should return the value(s) corresponding to key
 * 4. Throw appropriate exceptions wherever it makes sense
 */
interface SimpleMap<K, V> {
    void put(K k, V v);

    V get(K k);

    int size();
}

class Entry<K, V> {
    private K key;
    private V value;

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}

class Bucket<K,V> {
    private int hashCode;
    private LinkedList<Entry<K,V>> values;

    public int getHashCode() {
        return hashCode;
    }

    public void setHashCode(int hashCode) {
        this.hashCode = hashCode;
    }

    public LinkedList<Entry<K,V>> getValues() {
        return values;
    }

    public void setValues(LinkedList<Entry<K,V>> values) {
        this.values = values;
    }
}

class SimpleHashMapImpl<K, V> implements SimpleMap<K, V> {
    private Bucket[] buckets;
    private int capacity = 16;
    private int size = 0;

    public SimpleHashMapImpl() {
        init();
    }

    public SimpleHashMapImpl(int capacity) {
        if (capacity < 0) {
            throw new IllegalStateException(String.format("Capacity cannot be negative value %s.", capacity));
        }
        this.capacity = capacity;
    }

    private void init() {
        buckets = new Bucket[capacity];
    }

    @Override
    public void put(K k, V v) {
        if (k == null) {
            throw new IllegalStateException("Key cannot be null.");
        }
        int hashCode = getKeyHashCode(k);
        Bucket<K,V> bucket = buckets[hashCode];
        Entry<K, V> entry = new Entry<K, V>();
        entry.setKey(k);
        entry.setValue(v);
        if (bucket != null) {
            LinkedList<Entry<K,V>> list = bucket.getValues();
            if (list != null) {
                Iterator<Entry<K,V>> iterator = list.iterator();
                while (iterator.hasNext()) {
                    Entry node = iterator.next();
                    if (node.getKey().equals(k)) {
                        node.setValue(entry);
                        return;
                    }
                }
                list.add(entry);
                size++;
            }
        } else {
            bucket = new Bucket<>();
            bucket.setHashCode(hashCode);
            entry = new Entry<K, V>();
            entry.setKey(k);
            entry.setValue(v);
            LinkedList<Entry<K,V>> list = new LinkedList<>();
            list.add(entry);
            bucket.setValues(list);
            buckets[hashCode] = bucket;
            size++;
        }
    }


    @Override
    public V get(K k) {
        int hashCode = getKeyHashCode(k);
        Bucket<K,V> bucket = buckets[hashCode];
        if (bucket != null) {
            LinkedList<Entry<K,V>> list = bucket.getValues();
            while (list != null) {
                Iterator<Entry<K,V>> iterator = list.iterator();
                while (iterator.hasNext()) {
                    Entry<K,V> node = iterator.next();
                    if (node.getKey().equals(k)) {
                        return node.getValue();
                    }
                }
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private int getKeyHashCode(K y) {
        int someHash = y.hashCode();
        int hash = someHash % capacity;
        return hash;
    }

}

public class HashMapSolution {
    @Test
    public void testMapWriteOp() {
        SimpleHashMapImpl<String, Integer> map = new SimpleHashMapImpl<>();
        map.put("KING", 100);
        map.put("CLARK", 100);
        map.put("BLAKE", 100);
        map.put("FORD", 100);
        map.put("SMITH", 100);
        map.put("WARD", 100);
        map.put("JONES", 100);
        Assert.assertEquals(7, map.size());
    }

    @Test
    public void testMapReadOp() {
        SimpleHashMapImpl<String, Integer> map = new SimpleHashMapImpl<>();
        map.put("KING", 100);
        map.put("CLARK", 200);
        map.put("BLAKE", 300);
        map.put("FORD", 400);
        map.put("SMITH", 500);
        map.put("WARD", 600);
        Assert.assertEquals(Integer.valueOf(400), map.get("FORD"));
    }

    @Test(expected = IllegalStateException.class)
    public void testNegativeCapacity() {
        SimpleHashMapImpl<String, Integer> map = new SimpleHashMapImpl<>(-2);
    }

    @Test(expected = IllegalStateException.class)
    public void testNullKey() {
        SimpleHashMapImpl<String, Integer> map = new SimpleHashMapImpl<>();
        map.put(null, 100);
    }

    public static void main(String[] args) {
        JUnitCore.main(HashMapSolution.class.getName());
    }
}

