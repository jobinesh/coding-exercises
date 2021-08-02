package com.jobinesh.exercise.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Given the root of a binary tree, flatten the tree into a "linked list"
 * @param <T>
 */
public class LinkedListFromTree<T> {
    public List<LinkedList<TreeNode<T>>> buildLinkedList(TreeNode<T> node) {
        ArrayList<LinkedList<TreeNode<T>>> result = new ArrayList<>();
        LinkedList<TreeNode<T>> current = new LinkedList<>();
        current.add(node);

        while (!current.isEmpty()) {
            result.add(current);
            LinkedList<TreeNode<T>> parents = current;
            current = new LinkedList<>();
            Iterator<TreeNode<T>> iter = parents.iterator();
            while (iter.hasNext()) {
                TreeNode<T> parentNode = iter.next();
                if (parentNode.left != null) {
                    current.add(parentNode.left);
                }
                if (parentNode.right != null) {
                    current.add(parentNode.right);
                }
            }

        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode<String> node = new TreeNode();
        node.value = "1";
        node.left = new TreeNode();
        node.left.value = "2";
        node.left.left = new TreeNode();
        node.left.left.value = "4";
        node.left.right = new TreeNode();
        node.left.right.value = "5";
        node.right = new TreeNode();
        node.right.value = "3";
        LinkedListFromTree<String> linkedListFromTree = new LinkedListFromTree<>();
        List<LinkedList<TreeNode<String>>> list= linkedListFromTree.buildLinkedList( node);

        for(Object obj : list) {
            System.out.println(obj);
        }
    }
}
