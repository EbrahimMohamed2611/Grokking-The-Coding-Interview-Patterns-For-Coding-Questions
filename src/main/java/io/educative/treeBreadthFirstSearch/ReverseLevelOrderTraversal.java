package io.educative.treeBreadthFirstSearch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ReverseLevelOrderTraversal {


    public static List<List<Integer>> traverse(TreeNode root){
        List<List<Integer>> nodes = new LinkedList<>();
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
            nodes.add(0,nodesLevel);
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
