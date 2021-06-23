package com.jobinesh.exercise.search;

public class BinaryTree {



    static class Node {
        private String value;
        private Node left;
        private Node right;
    }

    public void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.value);
        preOrder(node.left);
        preOrder(node.right);
    }

    public void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.value);
    }

    public void inOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        System.out.println(node.value);
        postOrder(node.right);
    }

    public static void main(String[] args) {
        Node node = new Node();
        node.value = "1";
        node.left = new Node();
        node.left.value = "2";
        node.left.left = new Node();
        node.left.left.value = "4";
        node.left.right = new Node();
        node.left.right.value = "5";
        node.right = new Node();
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
