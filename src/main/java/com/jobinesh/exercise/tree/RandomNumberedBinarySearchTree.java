package com.jobinesh.exercise.tree;

import java.util.Random;

/**
 * Given a Binary Tree with children Nodes,
 * Return a random Node with equal Probability of selecting any Node in tree.
 */
public class RandomNumberedBinarySearchTree {
    static class BinarySearchTree {
        private TreeNode buildTree(Integer[] src, int beg, int end) {
            if (beg > end) {
                return null;
            }
            int mid = (beg + end) / 2;
            TreeNode root = new TreeNode();
            root.value = src[mid];
            TreeNode left = buildTree(src, beg, mid - 1);
            TreeNode right = buildTree(src, mid + 1, end);
            root.left = left;
            root.right = right;
            return root;
        }
    }

    static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;
        int size=0;

        public TreeNode() {
        }

        public TreeNode(int value) {
            this.value = value;
        }

        public TreeNode randomNode() {
            int leftsize= left == null? 0: left.size;
            Random random = new Random();
            int index = random.nextInt(size);
            if (leftsize == index) {
                return this;
            } else if (index < leftsize) {
                return left.randomNode();
            } else {
                return right.randomNode();
            }
        }

        public void insertInOrder(int data) {
            if (value < data) {
                if (right == null) {
                    right = new TreeNode(data);
                } else {
                    right.insertInOrder(data);
                }
            } else {
                if (left == null) {
                    left = new TreeNode(data);
                } else {
                    left.insertInOrder(data);
                }
            }
            size++;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "value=" + value +
                    '}';
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(30);
        root.insertInOrder(10);
        root.insertInOrder(40);
        System.out.println(root.randomNode());
    }
}
