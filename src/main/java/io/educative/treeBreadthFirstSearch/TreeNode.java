package io.educative.treeBreadthFirstSearch;

public class TreeNode {
    int val;
    TreeNode leftChild;
    TreeNode rightChild;

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
