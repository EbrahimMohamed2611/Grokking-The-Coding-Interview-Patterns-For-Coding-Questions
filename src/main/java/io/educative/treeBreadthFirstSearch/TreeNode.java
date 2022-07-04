package io.educative.treeBreadthFirstSearch;

public class TreeNode {
    public int val;
    public TreeNode leftChild;
    public TreeNode rightChild;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode() {
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                '}';
    }
}
