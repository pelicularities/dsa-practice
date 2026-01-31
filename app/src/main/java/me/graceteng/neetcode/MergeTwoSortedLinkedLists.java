package me.graceteng.neetcode;

public class MergeTwoSortedLinkedLists {
    public static class ListNode {
        final int val;

        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // guard clause
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        ListNode newListHead;
        if (list1.val <= list2.val) {
            newListHead = list1;
            list1 = list1.next;
        } else {
            newListHead = list2;
            list2 = list2.next;
        }

        ListNode newListCurrentNode = newListHead;
        ListNode newListNextNode;
        // while both lists are not empty
        while (list1 != null && list2 != null) {
            // look at current head of both lists
            // compare which is smaller
            // smaller one becomes the next node in combined list
            if (list1.val <= list2.val) {
                // list1 is smaller or equal
                // take next node from list 1
                newListNextNode = list1;
                list1 = list1.next;
            } else {
                // Case 2, list2 is smaller
                newListNextNode = list2;
                list2 = list2.next;
            }
            newListCurrentNode.next = newListNextNode;
            newListCurrentNode = newListNextNode;
        }
        // one list is empty
        // attach the remaining list to the end of the merged list
        if (list1 == null) {
            newListCurrentNode.next = list2;
        } else {
            newListCurrentNode.next = list1;
        }
        return newListHead;
    }
}
