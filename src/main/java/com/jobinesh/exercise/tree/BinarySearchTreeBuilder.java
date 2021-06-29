package com.jobinesh.exercise.tree;

/**
 * Create a Binary Search Tree from a sorted array
 */
public class BinarySearchTreeBuilder<T> {
    public TreeNode<T> build(T[] src){

        return buildTree(src,0, src.length-1);
    }
    private TreeNode<T> buildTree(T[] src, int beg,int end){
        if(beg >end){
            return null;
        }
        int mid= (beg+end)/2;
        TreeNode<T>  root= new TreeNode<>();
        root.value = src[mid];
        TreeNode<T> left = buildTree(src, beg, mid-1 );
        TreeNode<T> right = buildTree(src, mid+1, end );
        root.left =left;
        root.right = right;
        return root;
    }
    public void inOrder(TreeNode<T> node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.println(node.value);
        inOrder(node.right);
    }
    public static void main(String[] args){
        Integer[] src= new Integer[]{1,2,3,4,5,6,7,8};
        BinarySearchTreeBuilder<Integer> builder = new BinarySearchTreeBuilder<>();
        TreeNode root = builder.build(src);

        builder.inOrder(root);
    }
}
