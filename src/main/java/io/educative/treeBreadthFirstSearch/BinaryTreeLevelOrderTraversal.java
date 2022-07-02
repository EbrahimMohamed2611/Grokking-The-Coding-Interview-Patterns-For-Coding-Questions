package io.educative.treeBreadthFirstSearch;

import java.util.*;

public class BinaryTreeLevelOrderTraversal {

    public static List<List<Integer>> traverse(TreeNode root){
        List<List<Integer>> nodes = new ArrayList<>();
        if(root == null) return nodes;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> nodesLevel = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                TreeNode currentNode = queue.poll();
                nodesLevel.add(currentNode.val);
                if(currentNode.leftChild != null)
                queue.add(currentNode.leftChild);
                if(currentNode.rightChild != null)
                queue.add(currentNode.rightChild);
            }
            nodes.add(nodesLevel);
        }
        return nodes;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.leftChild = new TreeNode(2);
        root.rightChild = new TreeNode(3);

        root.leftChild.leftChild = new TreeNode(4);
        root.leftChild.rightChild = new TreeNode(5);

        root.rightChild.leftChild = new TreeNode(6);
        root.rightChild.rightChild = new TreeNode(7);
        System.out.println(traverse(root));
    }
}
