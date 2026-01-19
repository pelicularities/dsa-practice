package me.graceteng.neetcode;

public class ReverseLinkedList {
    public static ListNode reverseList(ListNode head) {
        // target time / space complexity: O(n) / O(1)
        ListNode previousNode = null;
        ListNode currentNode = head;
        while (currentNode != null) {
            ListNode temp = currentNode.next;
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = temp;
        }
        return previousNode;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
