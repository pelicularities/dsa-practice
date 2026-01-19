package me.graceteng.neetcode;

import me.graceteng.neetcode.ReverseLinkedList.ListNode;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ReverseLinkedListTest {
    public static Stream<Arguments> provideArgsForReverseLinkedListTest() {
        return Stream.of(
                Arguments.of(createLinkedList(0, 1, 2, 3), createDequeFromIntegers(3, 2, 1, 0)),
                Arguments.of(createLinkedList(1), createDequeFromIntegers(1))
        );
    }

    @ParameterizedTest
    @MethodSource("provideArgsForReverseLinkedListTest")
    void shouldCorrectlyReverseLinkedList(ListNode inputHead, Deque<Integer> expected) {
        ListNode resultHead = ReverseLinkedList.reverseList(inputHead);
        assertThat(resultHead).isNotNull();

        ListNode currentNode = resultHead;
        assertThat(currentNode.val).isEqualTo(expected.removeFirst());
        while (currentNode.next != null) {
            currentNode = currentNode.next;
            assertThat(currentNode.val).isEqualTo(expected.removeFirst());
        }
    }

    @Test
    void shouldReturnNullGivenNullInput() {
        ListNode resultHead = ReverseLinkedList.reverseList(null);
        assertThat(resultHead).isNull();
    }

    private static ListNode createLinkedList(Integer... values) {
        Deque<Integer> valuesList = createDequeFromIntegers(values);
        ListNode currentNode = new ListNode(valuesList.removeLast());
        while (!valuesList.isEmpty()) {
            ListNode previousNode = new ListNode(valuesList.removeLast(), currentNode);
            currentNode = previousNode;
        }
        return currentNode;
    }

    private static Deque<Integer> createDequeFromIntegers(Integer... values) {
        Deque<Integer> valuesList = new ArrayDeque<>();
        for (Integer value : values) {
            valuesList.addLast(value);
        }
        return valuesList;
    }
}