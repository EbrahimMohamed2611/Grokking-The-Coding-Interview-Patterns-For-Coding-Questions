package io.educative.treeDepthFirstSearch;

import io.educative.treeBreadthFirstSearch.TreeNode;

public class BinaryTreePathSum {

    public static boolean hasSum(TreeNode root, int sum) {
        if (root == null)
            return false;

        if ((sum - root.val == 0) && isLeaf(root))
            return true;
        boolean leftView = hasSum(root.leftChild, sum - root.val);
        boolean rightView = hasSum(root.rightChild, sum - root.val);
        return leftView || rightView;
    }

    private static boolean isLeaf(TreeNode node) {
        return node.rightChild == null && node.leftChild == null;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.leftChild = new TreeNode(2);
        root.rightChild = new TreeNode(3);

        root.leftChild.leftChild = new TreeNode(4);
        root.leftChild.rightChild = new TreeNode(5);

        root.rightChild.leftChild = new TreeNode(6);
        root.rightChild.rightChild = new TreeNode(7);
        System.out.println(hasSum(root,100));
    }
}
