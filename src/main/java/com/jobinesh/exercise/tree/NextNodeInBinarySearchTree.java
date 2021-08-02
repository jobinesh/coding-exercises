package com.jobinesh.exercise.tree;

/**
 * Given a binary tree and a node, we need to write a program to find inorder successor of this node
 */
public class NextNodeInBinarySearchTree {
    private TreeNode<Integer> getInorderSuccessor(TreeNode<Integer> node){
        if(node == null){
            return null;
        }
        if( node.right != null){
            return getLeftMostNode(node.right);
        }else{
            TreeNode<Integer> parent = getParent(node);
            return parent;
        }
    }
    public TreeNode<Integer> getParent(TreeNode<Integer> node){
       TreeNode<Integer> parentNode=node.parent;
        TreeNode<Integer> x= node;
        while(parentNode != null && parentNode.left != x){
            x=parentNode;
            parentNode = parentNode.parent;
        }
        return parentNode;
    }
    public TreeNode<Integer> getLeftMostNode(TreeNode<Integer> node){
        while(node.left !=null){
            node = node.left;
        }
        return node;
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
