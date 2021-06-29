package com.jobinesh.exercise.tree;

public class BinaryTree {


    public void preOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.println(node.value);
        preOrder(node.left);
        preOrder(node.right);
    }

    public void postOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.value);
    }

    public void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.println(node.value);
        inOrder(node.right);
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode();
        node.value = "1";
        node.left = new TreeNode();
        node.left.value = "2";
        node.left.left = new TreeNode();
        node.left.left.value = "4";
        node.left.right = new TreeNode();
        node.left.right.value = "5";
        node.right = new TreeNode();
        node.right.value = "3";
        BinaryTree btree= new BinaryTree();
        System.out.println("-------------Post Order-------------");
        btree.postOrder( node);
        System.out.println("-------------Pre Order-------------");
        btree.preOrder(node);
        System.out.println("--------------In Order------------");
        btree.inOrder(node);
        System.out.println("--------------------------");
    }
}
