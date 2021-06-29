package com.jobinesh.exercise.tree;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class GraphNode<T> {
    private T value;
    private Set<GraphNode<T>> neighbours = new HashSet<>();

    public GraphNode(T value) {
        this.value = value;
    }
    public void connect(GraphNode<T> graphNode){
        if( !neighbours.contains(graphNode)) {
            neighbours.add(graphNode);
            graphNode.connect(this);
        }
    }

    public T getValue() {
        return value;
    }

    public Set<GraphNode<T>> getNeighbours() {
        return neighbours;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GraphNode<?> graphNode = (GraphNode<?>) o;
        return Objects.equals(value, graphNode.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
