package com.jobinesh.exercise.tree;

/**
 * Check if a tree is binary search tree
 */
public class BinarySerachTreeCheck {
    public boolean isBinarySearchTree(TreeNode<Integer> node) {
        boolean result = isBST(node, null, null);
        return result;
    }

    public boolean isBST(TreeNode<Integer> node, Integer min, Integer max) {
        if (node == null) {
            return true;
        }
        if (min != null && node.value.intValue() <= min.intValue()) {
            return false;
        }
        if (max != null && node.value.intValue() > max.intValue()) {
            return false;
        }
        if (!isBST(node.left, min, node.value) || !isBST(node.right, node.value, max)) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode<Integer> node = new TreeNode<>();
        node.value = Integer.valueOf(10);
        node.left = new TreeNode();
        node.left.value = Integer.valueOf(8);
        node.left.left = new TreeNode();
        node.left.left.value = Integer.valueOf(4);
        node.left.right = new TreeNode();
        node.left.right.value = Integer.valueOf(9);
        node.right = new TreeNode();
        node.right.value = Integer.valueOf(30);
        System.out.println( new BinarySerachTreeCheck().isBinarySearchTree(node));

    }
}
