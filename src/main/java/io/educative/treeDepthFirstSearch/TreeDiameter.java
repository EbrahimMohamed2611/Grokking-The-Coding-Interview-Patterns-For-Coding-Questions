package io.educative.treeDepthFirstSearch;

import io.educative.treeBreadthFirstSearch.TreeNode;

public class TreeDiameter {

    public static int findDiameter(TreeNode root) {
        int[] diameter = new int[1];

        findDiameter(root, diameter);
        return diameter[0];
    }

    private static int findDiameter(TreeNode root,  int[] diameter) {
        if (root == null) return 0;

        int leftHeight = findDiameter(root.leftChild,  diameter);
        int rightHeight = findDiameter(root.rightChild, diameter);
        diameter[0] = Math.max(diameter[0], leftHeight + rightHeight);
        return Math.max(leftHeight, rightHeight)+1;
    }


    public static void main(String[] args) {
//        TreeNode root = new TreeNode(1);
//        root.leftChild = new TreeNode(7);
//        root.rightChild = new TreeNode(9);
//
//        root.rightChild.leftChild = new TreeNode(2);
//        root.rightChild.rightChild = new TreeNode(9);
//        System.out.println(findDiameter(root));

        TreeNode root = new TreeNode(1);
        root.leftChild = new TreeNode(7);
        root.rightChild = new TreeNode(9);
        root.leftChild.leftChild = new TreeNode(50);

        root.rightChild.leftChild = new TreeNode(2);
        root.rightChild.rightChild = new TreeNode(9);
        root.rightChild.rightChild.rightChild = new TreeNode(9);
        System.out.println(findDiameter(root));
    }
}
