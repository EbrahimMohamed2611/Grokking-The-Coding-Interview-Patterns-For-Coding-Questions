package io.educative.treeBreadthFirstSearch;

import java.util.*;

public class ZigzagTraversal {

    enum Direction{
        LEFT, RIGHT
    }

    public static List<List<Integer>> zigzagTraversal(TreeNode root){
        List<List<Integer>> values = new LinkedList<>();
        if(root == null)
            return values;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        Direction currentDirection = Direction.LEFT;
        while (!queue.isEmpty()){
            List<Integer> linkedList = new LinkedList<>();
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                if(currentDirection == Direction.LEFT)
                linkedList.add(node.val);
                else
                    linkedList.add(0,node.val);
                if(node.leftChild != null)
                    queue.add(node.leftChild);
                if(node.rightChild != null)
                    queue.add(node.rightChild);
            }
            if(currentDirection == Direction.LEFT)
                currentDirection = Direction.RIGHT;
            else
                currentDirection = Direction.LEFT;

            values.add(linkedList);
        }
        return values;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.leftChild = new TreeNode(2);
        root.rightChild = new TreeNode(3);

        root.leftChild.leftChild = new TreeNode(4);
        root.leftChild.rightChild = new TreeNode(5);

        root.rightChild.leftChild = new TreeNode(6);
        root.rightChild.rightChild = new TreeNode(7);
        System.out.println(zigzagTraversal(root));
    }
}
