package me.graceteng;

import lombok.SneakyThrows;
import me.graceteng.BinaryTree.Node;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class BinaryTreeTest {
    @Test
    @SneakyThrows
    void shouldAddNodeToLeftGivenNewNodeIsSmallerThanRoot() {
        BinaryTree binaryTree = new BinaryTree(new Node(1));
        Node root = binaryTree.getRoot();
        Node newNode = new Node(0);
        binaryTree.add(newNode);
        Assertions.assertThat(root.getLeft()).isEqualTo(newNode);
        Assertions.assertThat(root.getRight()).isNull();
    }

    @Test
    @SneakyThrows
    void shouldAddNodeToRightGivenNewNodeIsLargerThanRoot() {
        BinaryTree binaryTree = new BinaryTree(new Node(1));
        Node root = binaryTree.getRoot();
        Node newNode = new Node(2);
        binaryTree.add(newNode);
        Assertions.assertThat(root.getLeft()).isNull();
        Assertions.assertThat(root.getRight()).isEqualTo(newNode);
    }

    @Test
    @SneakyThrows
    void shouldAddNodeToCorrectLeftmostLeafPositionInLeftBranch() {
        BinaryTree binaryTree = new BinaryTree(new Node(1));
        Node root = binaryTree.getRoot();
        binaryTree.add(new Node(0));
        Node newNode = new Node(-1);
        binaryTree.add(newNode);

        Assertions.assertThat(root.getLeft().getLeft()).isEqualTo(newNode);
        Assertions.assertThat(root.getRight()).isNull();
    }

    @Test
    @SneakyThrows
    void shouldAddNodeToCorrectLeafPositionInLeftBranch() {
        BinaryTree binaryTree = new BinaryTree(new Node(1));
        Node root = binaryTree.getRoot();
        binaryTree.add(new Node(-1));
        Node newNode = new Node(-0);
        binaryTree.add(newNode);

        Assertions.assertThat(root.getLeft().getRight()).isEqualTo(newNode);
        Assertions.assertThat(root.getRight()).isNull();
    }

    @Test
    @SneakyThrows
    void shouldAddNodeToCorrectRightmostLeafPositionInRightBranch() {
        BinaryTree binaryTree = new BinaryTree(new Node(1));
        Node root = binaryTree.getRoot();
        binaryTree.add(new Node(2));
        Node newNode = new Node(3);
        binaryTree.add(newNode);

        Assertions.assertThat(root.getLeft()).isNull();
        Assertions.assertThat(root.getRight().getRight()).isEqualTo(newNode);
    }

    @Test
    @SneakyThrows
    void shouldAddNodeToCorrectLeafPositionInRightBranch() {
        BinaryTree binaryTree = new BinaryTree(new Node(1));
        Node root = binaryTree.getRoot();
        binaryTree.add(new Node(3));
        Node newNode = new Node(2);
        binaryTree.add(newNode);

        Assertions.assertThat(root.getLeft()).isNull();
        Assertions.assertThat(root.getRight().getLeft()).isEqualTo(newNode);
    }
}