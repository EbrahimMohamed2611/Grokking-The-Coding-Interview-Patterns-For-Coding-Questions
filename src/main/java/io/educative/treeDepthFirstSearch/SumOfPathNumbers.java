package io.educative.treeDepthFirstSearch;

import io.educative.treeBreadthFirstSearch.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class SumOfPathNumbers {

    public static int findSumOfPath(TreeNode root) {

        return findSumOfPath(root, 0);
    }

    private static int findSumOfPath(TreeNode root, int sum) {
        if (root == null)
            return 0;
        sum = sum * 10 + root.val;
        if (isLeaf(root)) {
            return sum;
        }

        int leftPathSum = findSumOfPath(root.leftChild, sum);
        int rightPathSum = findSumOfPath(root.rightChild, sum);
        return leftPathSum + rightPathSum;

    }


    public static int findSumOfPath2(TreeNode root) {
        List<List<Integer>> pathSums = new ArrayList<>();
        findSumOfPath2(root, pathSums, new ArrayList<>());
        System.out.println(pathSums);
        int sum = 0;
        for (List<Integer> path : pathSums) {
            int pathSum = 0;
            for (int val : path) {
                pathSum = pathSum * 10 + val;
            }
            sum += pathSum;
        }
        return sum;


    }

    private static void findSumOfPath2(TreeNode root, List<List<Integer>> pathSums, List<Integer> pathSum) {
        if (root == null)
            return;
        pathSum.add(root.val);
        if (isLeaf(root)) {
            pathSums.add(pathSum);
            return;
        }

        findSumOfPath2(root.leftChild, pathSums, new ArrayList<>(pathSum));
        findSumOfPath2(root.rightChild, pathSums, new ArrayList<>(pathSum));

    }

    public static int findSumOfPath3(TreeNode root) {
        List<List<Integer>> pathSums = new ArrayList<>();
        findSumOfPath3(root, pathSums, new ArrayList<>());
        System.out.println(pathSums);
        int sum = 0;
        for (List<Integer> path : pathSums) {
            int pathSum = 0;
            for (int val : path) {
                pathSum = pathSum * 10 + val;
            }
            sum += pathSum;
        }
        return sum;
    }

    private static void findSumOfPath3(TreeNode root, List<List<Integer>> pathSums, List<Integer> pathSum) {
        if (root == null)
            return;
        pathSum.add(root.val);
        if (isLeaf(root)) {
            pathSums.add(new ArrayList<>(pathSum));
            return;
        }

        findSumOfPath3(root.leftChild, pathSums, pathSum);
        pathSum.remove(pathSum.size() - 1);
        findSumOfPath3(root.rightChild, pathSums, pathSum);

    }


    private static boolean isLeaf(TreeNode node) {
        return node.rightChild == null && node.leftChild == null;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.leftChild = new TreeNode(7);
        root.rightChild = new TreeNode(9);

        root.rightChild.leftChild = new TreeNode(2);
        root.rightChild.rightChild = new TreeNode(9);
        System.out.println(findSumOfPath(root));
        System.out.println(findSumOfPath2(root));
        System.out.println(findSumOfPath3(root));
        System.out.println(17 + 192 + 199);
    }
}
