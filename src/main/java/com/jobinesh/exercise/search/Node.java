package com.jobinesh.exercise.search;

import java.util.HashSet;
import java.util.Set;

public class Node<T> {
    private T value;
    private Set<Node<T>> neighbours = new HashSet<>();

    public Node(T value) {
        this.value = value;
    }
    public void connect(Node<T> node){
        if( !neighbours.contains(node )) {
            neighbours.add(node);
            node.connect(this);
        }
    }

    public T getValue() {
        return value;
    }

    public Set<Node<T>> getNeighbours() {
        return neighbours;
    }
}
