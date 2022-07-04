package io.educative.treeBreadthFirstSearch;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderSuccessor {

    public static TreeNode levelOrderSuccessor(TreeNode root, TreeNode target) {
        TreeNode nodeSuccessor = new TreeNode();
        if (root == null)
            return nodeSuccessor;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean flag = false;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {

                TreeNode node = queue.poll();
                if (flag)
                    return node;
                if (node.val == target.val)
                    flag = true;
                if (node.leftChild != null)
                    queue.add(node.leftChild);
                if (node.rightChild != null)
                    queue.add(node.rightChild);
            }
        }

        return nodeSuccessor;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.leftChild = new TreeNode(2);
        root.rightChild = new TreeNode(3);

        root.leftChild.leftChild = new TreeNode(4);
        root.leftChild.rightChild = new TreeNode(5);

        root.rightChild.leftChild = new TreeNode(6);
        root.rightChild.rightChild = new TreeNode(7);
        System.out.println(levelOrderSuccessor(root, new TreeNode(2)));
        System.out.println(levelOrderSuccessor(root, new TreeNode(1)));
        System.out.println(levelOrderSuccessor(root, new TreeNode(7)));
    }
}
