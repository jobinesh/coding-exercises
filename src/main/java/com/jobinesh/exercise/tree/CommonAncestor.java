package com.jobinesh.exercise.tree;

/**
 * Find first common ancestor of two nodes.
 */
public class CommonAncestor {
    public TreeNode commonAncestor(TreeNode node1, TreeNode node2) {
        if (node1 == node2) {
            return node1;
        }
        int depth1 = depth(node1);
        int depth2 = depth(node2);
        TreeNode shallowNode = depth1 - depth2 > 0 ? node2 : node1;
        TreeNode deepNode = depth1 - depth2 > 0 ? node1 : node2;
        deepNode = upNode(deepNode, Math.abs(depth1 - depth2));
        while( shallowNode != deepNode && shallowNode != null ){
            shallowNode= shallowNode.parent;
            deepNode = deepNode.parent;
        }
        return shallowNode;
    }

    private TreeNode upNode(TreeNode node, int depth) {
        while (depth > 0) {
            node = node.parent;
            depth--;
        }
        return node;
    }

    private int depth(TreeNode node) {
        int depth = 0;
        while (node != null) {
            depth++;
            node = node.parent;
        }
        return depth;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.parent=root;
        root.right = new TreeNode(3);
        root.right.parent=root;
        root.left.left = new TreeNode(4);
        root.left.left.parent=root.left;
        root.left.right = new TreeNode(5);
        root.left.right.parent=root.left;
        root.right.left = new TreeNode(6);
        root.right.left.parent=root.right ;
        root.right.right = new TreeNode(7);
        root.right.right.parent=root.right ;
        CommonAncestor btree = new CommonAncestor();
        System.out.println("-------------Common  Ancestor-------------");
        TreeNode node= btree.commonAncestor(root.left.left ,root.left.right);
        System.out.println(node.toString());
    }
}
