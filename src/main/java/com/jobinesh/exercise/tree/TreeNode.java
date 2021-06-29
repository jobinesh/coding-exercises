package com.jobinesh.exercise.tree;

public class TreeNode<T> {
    T value;
    TreeNode<T> left;
    TreeNode<T> right;
    int level;//for LevelOrder traversal
}
