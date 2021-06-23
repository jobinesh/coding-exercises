package com.jobinesh.exercise.search;

import java.util.ArrayList;
import java.util.List;

class Tree<T> {
    private T value;
    private final List<Tree<T>> children;

    public Tree(T value) {
        children = new ArrayList<>();
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void addChild(Tree<T> child) {
        children.add(child);
    }

    public List<Tree<T>> getChildren() {
        return children;
    }
}
