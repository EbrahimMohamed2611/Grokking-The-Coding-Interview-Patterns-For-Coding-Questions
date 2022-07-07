package io.educative.treeDepthFirstSearch;

import io.educative.treeBreadthFirstSearch.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class AllPathsForASum {


    public static List<List<Integer>> allPathsSum(TreeNode root, int sum) {
        List<List<Integer>> allPaths = new ArrayList<>();
        allPathsRecursively(root, sum, allPaths, new ArrayList<>());
        return allPaths;
    }

    private static void allPathsRecursively(TreeNode node, int sum, List<List<Integer>> pathsSum, List<Integer> path) {
        if (node == null)
            return;

        path.add(node.val);
        if (sum == node.val && isLeaf(node)) {
            pathsSum.add(new ArrayList<>(path));
            System.out.println(new ArrayList<>(path));
            return;
        }
        int newSum = sum - node.val;
        allPathsRecursively(node.leftChild, newSum, pathsSum, path);
        allPathsRecursively(node.rightChild, newSum, pathsSum, path);

        path.remove(path.size()-1);
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
        System.out.println(allPathsSum(root, 10));
    }


}
