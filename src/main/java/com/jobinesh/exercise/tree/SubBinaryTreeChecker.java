package com.jobinesh.exercise.tree;

/**
 * Check if a binary tree is subtree of another binary tree
 */
public class SubBinaryTreeChecker {
    /* This function returns true if t2 is a subtree of t1, otherwise false */
    public boolean isSubtree(TreeNode t1, TreeNode t2){
        if( t1 == null || t2 == null){
            return false;
        }

        if (isIdentical(t1, t2)){
            return true;
        }
        return  isSubtree( t1.left, t2) ||  isSubtree( t1.right, t2);
    }
    private boolean isIdentical(TreeNode t1, TreeNode t2){
        if( t1== null && t2 ==null){
            return true;
        }
        if( t1 == null || t2 == null){
            return false;
        }
        boolean result = (t1.value == t2.value )
                && isIdentical( t1.left, t2.left)
                && isIdentical( t1.right, t2.right);
        return result;
    }
    public static void main(String[] args){
        // TREE 1
        /* Construct the following tree
              26
             /   \
            10     3
           /    \     \
          4      6      3
           \
            30  */

        TreeNode root1 = new TreeNode(26);
        root1.right = new TreeNode(3);
        root1.right.right = new TreeNode(3);
        root1.left = new TreeNode(10);
        root1.left.left = new TreeNode(4);
        root1.left.left.right = new TreeNode(30);
        root1.left.right = new TreeNode(6);

        // TREE 2
        /* Construct the following tree
           10
         /    \
         4      6
          \
          30  */

        TreeNode root2 = new TreeNode(10);
        root2.right = new TreeNode(6);
        root2.left = new TreeNode(4);
        root2.left.right = new TreeNode(30);
        SubBinaryTreeChecker checker= new SubBinaryTreeChecker();
        if (checker.isSubtree(root1, root2))
            System.out.println("Tree 2 is subtree of Tree 1 ");
        else
            System.out.println("Tree 2 is not a subtree of Tree 1");

    }
}
