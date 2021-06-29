package com.jobinesh.exercise.tree;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.JUnitCore;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, find its minimum depth. The minimum depth
 * is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 *
 * @param <T>
 */
public class BinaryTreeMinDepth<T> {

    public int minDepth(TreeNode<T> rootNode) {
        Queue<TreeNode<T>> queue = new LinkedList<>();
        queue.add(rootNode);
        while (!queue.isEmpty()) {
            TreeNode<T> currentNode = queue.poll();
            if (currentNode.left == null && currentNode.right == null) {
                return currentNode.level;
            }
            if (currentNode.left != null) {
                TreeNode<T> leftNode = currentNode.left;
                leftNode.level = currentNode.level + 1;
                queue.add(leftNode);

            }
            if (currentNode.right == null) {
                TreeNode<T> rightNode = currentNode.right;
                rightNode.level = currentNode.level + 1;
                queue.add(rightNode);
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        JUnitCore.main(BinaryTreeMinDepth.class.getName());
    }


    @Test
    public void testTreeDepthEquals() {
        TreeNode<String> node = new TreeNode<>();
        node.value = "1";
        node.left = new TreeNode();
        node.left.value = "2";
        node.left.left = new TreeNode();
        node.left.left.value = "4";
        node.left.right = new TreeNode();
        node.left.right.value = "5";
        node.right = new TreeNode();
        node.right.value = "3";
        int result = new BinaryTreeMinDepth().minDepth(node);
        Assert.assertEquals(2, result);
    }
    @Test
    public void testTreeDepthNotEquals() {
        TreeNode<String> node = new TreeNode<>();
        node.value = "1";
        node.left = new TreeNode();
        node.left.value = "2";
        node.left.left = new TreeNode();
        node.left.left.value = "4";
        node.left.right = new TreeNode();
        node.left.right.value = "5";
        node.right = new TreeNode();
        node.right.value = "3";
        int result = new BinaryTreeMinDepth().minDepth(node);
        Assert.assertNotEquals(5, result);
    }

}
