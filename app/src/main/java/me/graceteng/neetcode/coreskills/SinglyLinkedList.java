package me.graceteng.neetcode.coreskills;

import java.util.ArrayList;

public class SinglyLinkedList {
    static class Node {
        private final int val;

        private Node next;

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }

        public int getVal() {
            return val;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    Node head;

    public SinglyLinkedList() {
        head = null;
    }

    public int get(int index) {
        if (head == null) {
            return -1;
        }
        int counter = 0;
        Node current = head;
        while (current.getNext() != null && counter < index) {
            counter++;
            current = current.getNext();
        }
        // which stopping condition was met?
        // Condition 1: we found the index
        if (counter == index) {
            return current.getVal();
        }

        // Condition 1: we reached the end of the list
        return -1;
    }

    public void insertHead(int val) {
        Node newHead = new Node(val, head);
        head = newHead;
    }

    public void insertTail(int val) {
        Node newTail = new Node(val, null);

        // special case: if list is currently empty
        if (head == null) {
            head = newTail;
            return;
        }

        // regular case: list is not empty
        // find the current tail
        Node current = head;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        // current is the current tail
        current.setNext(newTail);
    }

    public boolean remove(int index) {
        if (head == null) {
            return false;
        }

        int counter = 0;
        Node current = head;
        Node previous = null;
        while (current.getNext() != null && counter < index) {
            counter++;
            previous = current;
            current = current.getNext();
        }
        // which stopping condition was met?
        // Condition 1: we found the index to be removed
        if (counter == index) {
            if (previous == null) {
                // edge case: if previous is null,
                // that implies that the node to be removed
                // is the head of the list
                head = current.getNext();
            } else {
                // normal case
                previous.setNext(current.getNext());
            }
            return true;
        }

        // Condition 2: we reached the end of the list
        return false;
    }

    public ArrayList<Integer> getValues() {
        ArrayList<Integer> values = new ArrayList<>();
        Node current = head;
        while (current != null) {
            values.add(current.getVal());
            current = current.getNext();
        }
        return values;
    }
}
