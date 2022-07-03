package io.educative.treeBreadthFirstSearch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelAveragesInABinaryTree {

    public static List<Double> findLevelAverage(TreeNode root) {
        List<Double> average = new ArrayList<>();
        if (root == null) return average;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            double sum = 0;
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                sum += node.val;

                if (node.leftChild != null)
                    queue.add(node.leftChild);

                if (node.rightChild != null)
                    queue.add(node.rightChild);
            }
            average.add(sum/levelSize);
        }
        return average;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.leftChild = new TreeNode(2);
        root.rightChild = new TreeNode(3);

        root.leftChild.leftChild = new TreeNode(4);
        root.leftChild.rightChild = new TreeNode(5);

        root.rightChild.leftChild = new TreeNode(6);
        root.rightChild.rightChild = new TreeNode(7);
        findLevelAverage(root).forEach(System.out::println);
    }
}
