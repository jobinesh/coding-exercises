package com.jobinesh.exercise.tree;

public class TreeNode<T> {
    T value;
    TreeNode<T> left;
    TreeNode<T> right;
    TreeNode<T> parent;
    int level;//for LevelOrder traversal

    public TreeNode() {
    }

    public TreeNode(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "value=" + value +
                '}';
    }
}
