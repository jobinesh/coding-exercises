package com.jobinesh.exercise.tree;

/**
 * Check if a binary tree is balanced
 */
public class BalancedBinaryTree<T> {
    public boolean isBalanced(TreeNode<T> treeNode){
        if(treeNode==null){
            return true;
        }
        int leftHt = getHeight(treeNode.left);
        int rightHt = getHeight(treeNode.right);
        if( Math.abs( leftHt-rightHt)>1){
            return false;
        }else {
            return isBalanced(treeNode.left ) && isBalanced( treeNode.right);
        }
    }
    private int getHeight(TreeNode<T> node){
        if(node==null){
            return 0;
        }
        int htLeft =getHeight(node.left);
        int htRight = getHeight(node.right);
        if( htLeft == Integer.MIN_VALUE){
            return htLeft;
        }
        if( htRight == Integer.MIN_VALUE){
            return htLeft;
        }
        if( Math.abs(htLeft - htRight)>1 ){
            return Integer.MIN_VALUE;
        }else{
            return Math.max(htLeft, htRight )+1;
        }

    }
    public static void main(String[] args){
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
        BalancedBinaryTree<String> tree = new BalancedBinaryTree();
        System.out.println(tree.isBalanced(node));
    }
}
