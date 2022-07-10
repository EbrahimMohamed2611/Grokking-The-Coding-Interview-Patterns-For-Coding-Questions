package io.educative.treeBreadthFirstSearch;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthOfBinaryTree {

    public static int maximumDepth(TreeNode root) {
        int maximumDepth = 0;
        if (root == null)
            return maximumDepth;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            maximumDepth++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode currentNode = queue.poll();
                if (currentNode.leftChild != null)
                    queue.add(currentNode.leftChild);
                if (currentNode.rightChild != null)
                    queue.add(currentNode.rightChild);
            }
        }
        return maximumDepth;
    }

    public static int maximumDepthRecur(TreeNode root) {

        return maximumDepthRecur(root, 0) + 1;
    }

    private static int maximumDepthRecur(TreeNode root, int depth) {
        if (root == null)
            return 0;
        if (isLeaf(root))
            return depth;
        int leftDepth = maximumDepthRecur(root.leftChild, depth + 1);
        int rightDepth = maximumDepthRecur(root.rightChild, depth + 1);
        return Math.max(leftDepth, rightDepth);
    }

    private static boolean isLeaf(TreeNode node) {
        return node.rightChild == null && node.leftChild == null;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.leftChild = new TreeNode(7);
        root.rightChild = new TreeNode(1);

        root.rightChild.leftChild = new TreeNode(10);
        root.rightChild.rightChild = new TreeNode(5);
        System.out.println(maximumDepth(root));
        System.out.println(maximumDepthRecur(root));
    }
}
