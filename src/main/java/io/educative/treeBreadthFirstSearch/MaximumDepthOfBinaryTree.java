package io.educative.treeBreadthFirstSearch;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthOfBinaryTree {

    public static int maximumDepth(TreeNode root) {
        int maximumDepth = 0;
        if(root == null)
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

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.leftChild = new TreeNode(7);
        root.rightChild = new TreeNode(1);

        root.rightChild.leftChild = new TreeNode(10);
        root.rightChild.rightChild = new TreeNode(5);
        System.out.println(maximumDepth(root));
    }
}
