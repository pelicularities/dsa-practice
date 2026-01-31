package me.graceteng.neetcode;

import me.graceteng.neetcode.MergeTwoSortedLinkedLists.ListNode;
import org.junit.jupiter.api.Test;

import java.util.List;

import static me.graceteng.neetcode.MergeTwoSortedLinkedLists.mergeTwoLists;
import static org.assertj.core.api.Assertions.assertThat;

class MergeTwoSortedLinkedListsTest {
    @Test
    void shouldMergeTwoSortedLinkedListsIntoOneSortedList() {
        ListNode list1 = createLinkedList(List.of(1, 2, 4));
        ListNode list2 = createLinkedList(List.of(1, 3, 5));

        ListNode result = mergeTwoLists(list1, list2);

        List<Integer> expected = List.of(1, 1, 2, 3, 4, 5);
        ListNode node = result;
        for (Integer expectedVal : expected) {
            assertThat(node.val).isEqualTo(expectedVal);
            node = node.next;
        }
    }

    @Test
    void shouldMergeOneSortedAndOneEmptyIntoOneSortedList() {
        ListNode list2 = createLinkedList(List.of(1, 2));

        ListNode result = mergeTwoLists(null, list2);

        List<Integer> expected = List.of(1, 2);
        ListNode node = result;
        for (Integer expectedVal : expected) {
            assertThat(node.val).isEqualTo(expectedVal);
            node = node.next;
        }
    }

    @Test
    void shouldMergeTwoEmptyListsIntoOneEmptyList() {
        ListNode result = mergeTwoLists(null, null);
        assertThat(result).isNull();
    }

    private static ListNode createLinkedList(List<Integer> list) {
        List<Integer> reversed = list.reversed();

        ListNode currentHead = new ListNode(reversed.get(0));
        for (int i = 1; i < reversed.size(); i++) {
            currentHead = new ListNode(reversed.get(i), currentHead);
        }
        return currentHead;
    }
}