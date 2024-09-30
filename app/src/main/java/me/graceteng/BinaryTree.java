package me.graceteng;

import lombok.Getter;
import lombok.Setter;

@Getter
public class BinaryTree {
    private Node root;

    @Getter
    @Setter
    public static class Node {
        private int value;
        private Node left;
        private Node right;
        public Node(int value) {
            this.value = value;
        }
    }
    public BinaryTree(Node root) {
        this.root = root;
    }

    public void add(Node newNode) throws Exception {
        BinaryTree.addNodeRecursively(newNode, this.root);
    }

    private static void addNodeRecursively(Node newNode, Node rootNode) throws Exception {
        // if newNode's value equals rootNode's, throw exception
        // we don't accept duplicates in our binary tree
        if (newNode.getValue() == rootNode.getValue()) {
            throw new Exception("Duplicate node value");
        }

        if (newNode.getValue() < rootNode.getValue()) {
            if (rootNode.getLeft() == null) {
                // base case:
                // if newNode < rootNode and rootNode's left child is empty,
                // add newNode as rootNode's immediate left child
                rootNode.setLeft(newNode);
            } else {
                // recursive case:
                // if newNode < rootNode and rootNode's left child is not empty,
                // recursively call add on the left child
                BinaryTree.addNodeRecursively(newNode, rootNode.getLeft());
            }
        }

        if (newNode.getValue() > rootNode.getValue()) {
            if (rootNode.getRight() == null) {
                // base case:
                // if newNode > rootNode and rootNode's right child is empty,
                // add newNode as rootNode's immediate right child
                rootNode.setRight(newNode);
            } else {
                // recursive case:
                // if newNode > rootNode and rootNode's right child is not empty,
                // recursively call add on the right child
                BinaryTree.addNodeRecursively(newNode, rootNode.getRight());
            }
        }
    }
}
