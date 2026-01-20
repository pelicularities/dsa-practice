package me.graceteng.neetcode.coreskills;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class SinglyLinkedListTest {
    SinglyLinkedList list;

    @BeforeEach
    void setUp() {
        list = new SinglyLinkedList();
    }

    @Test
    void shouldGetValueOfIthNode() {
        list.insertHead(0);
        list.insertHead(1);
        list.insertHead(2);
        list.insertHead(3);
        assertThat(list.get(1)).isEqualTo(2);
        assertThat(list.get(3)).isEqualTo(0);
    }

    @Test
    void shouldReturnMinusOneWhenInvokingGetGivenHeadIsNull() {
        assertThat(list.get(0)).isEqualTo(-1);
    }

    @Test
    void shouldReturnMinusOneWhenInvokingGetGivenIndexOutOfBounds() {
        list.insertHead(0);
        list.insertHead(1);
        list.insertHead(2);
        list.insertHead(3);
        assertThat(list.get(99)).isEqualTo(-1);
    }

    @Test
    void shouldInsertNodeWithCorrectValueAtHead() {
        list.insertHead(4);
        assertThat(list.get(0)).isEqualTo(4);
    }

    @Test
    void shouldInsertNodeWithCorrectValueAtTail() {
        list.insertHead(0);
        list.insertHead(1);
        list.insertHead(2);
        list.insertHead(3);
        list.insertTail(5);
        assertThat(list.get(4)).isEqualTo(5);
    }

    @Test
    void shouldRemoveIthNodeAndReturnTrue() {
        list.insertHead(0);
        list.insertHead(1);
        list.insertHead(2);
        list.insertHead(3);
        assertThat(list.remove(1)).isTrue();
        assertThat(list.get(1)).isEqualTo(1);
    }

    @Test
    void shouldReturnFalseWhenInvokingRemoveGivenHeadIsNull() {
        assertThat(list.remove(0)).isFalse();
    }

    @Test
    void shouldReturnFalseWhenInvokingRemoveGivenIndexOutOfBounds() {
        list.insertHead(0);
        list.insertHead(1);
        list.insertHead(2);
        list.insertHead(3);
        assertThat(list.remove(99)).isFalse();
    }

    @Test
    void shouldReturnArrayOfAllValuesInOrder() {
        list.insertHead(0);
        list.insertHead(1);
        list.insertHead(2);
        list.insertHead(3);
        assertThat(list.getValues()).containsExactly(3, 2, 1, 0);
    }
}