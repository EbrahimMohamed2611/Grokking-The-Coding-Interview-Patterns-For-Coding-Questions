package io.educative.treeBreadthFirstSearch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightViewOfABinaryTree {

    public static List<TreeNode> traverse(TreeNode root){
        List<TreeNode> rightViewNodes = new ArrayList<>();
        if(root == null) return rightViewNodes;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                if(i == levelSize-1)
                    rightViewNodes.add(node);

                if(node.leftChild != null)
                    queue.add(node.leftChild);

                if(node.rightChild != null)
                    queue.add(node.rightChild);
            }
        }
        return rightViewNodes;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.leftChild = new TreeNode(2);
        root.rightChild = new TreeNode(3);

        root.leftChild.leftChild = new TreeNode(4);
        root.leftChild.rightChild = new TreeNode(5);

        root.rightChild.leftChild = new TreeNode(6);
        root.rightChild.rightChild = new TreeNode(7);
       traverse(root).forEach(node -> System.out.println(node.val));
    }
}
