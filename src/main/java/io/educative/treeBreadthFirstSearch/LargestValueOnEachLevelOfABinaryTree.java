package io.educative.treeBreadthFirstSearch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LargestValueOnEachLevelOfABinaryTree {

    public static List<Integer> largestValues(TreeNode root) {
        List<Integer> largestValuesInEachLevel = new ArrayList<>();
        if(root == null)
            return largestValuesInEachLevel;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int max;
        while (!queue.isEmpty()){
            max = Integer.MIN_VALUE;
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                if(node.val >= max)
                    max = node.val;
                if(node.leftChild != null)
                    queue.add(node.leftChild);
                if(node.rightChild != null)
                    queue.add(node.rightChild);
            }
            largestValuesInEachLevel.add(max);
        }

        return largestValuesInEachLevel;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.leftChild = new TreeNode(2);
        root.rightChild = new TreeNode(3);

        root.leftChild.leftChild = new TreeNode(4);
        root.leftChild.rightChild = new TreeNode(5);

        root.rightChild.leftChild = new TreeNode(6);
        root.rightChild.rightChild = new TreeNode(7);
        largestValues(root).forEach(System.out::println);
    }
}
