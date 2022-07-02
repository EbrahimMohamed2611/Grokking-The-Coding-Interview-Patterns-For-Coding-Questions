package io.educative.treeBreadthFirstSearch;

import java.util.*;

public class MinimumDepthOfِBinaryTree {

    public static int minimumDepth(TreeNode root) {
        int minimumDepth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            minimumDepth++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode currentNode = queue.poll();
                if (isLeaf(currentNode))
                    return minimumDepth;
                if (currentNode.leftChild != null)
                    queue.add(currentNode.leftChild);
                if (currentNode.rightChild != null)
                    queue.add(currentNode.rightChild);
            }
        }
        return minimumDepth;
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
        System.out.println(minimumDepth(root));
    }
}
