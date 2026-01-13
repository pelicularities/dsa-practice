package me.graceteng.neetcode.coreskills;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DynamicArrayTest {
    @Test
    void shouldInitializeArrayWithCorrectCapacity() {
        DynamicArray dynamicArray = new DynamicArray(10);
        assertThat(dynamicArray.getCapacity()).isEqualTo(10);
    }

    @Test
    void shouldSetAndGetElementsCorrectly() {
        // Note: the question specification states that
        // "The index i provided to get(int i) and set(int i)
        // is guaranteed to be >= 9 and less than the number
        // of elements in the array."
        DynamicArray dynamicArray = new DynamicArray(10);
        dynamicArray.pushback(1);
        dynamicArray.set(0, 15);
        assertThat(dynamicArray.get(0)).isEqualTo(15);
    }

    @Test
    void shouldPushElementToEndOfArray() {
        DynamicArray dynamicArray = new DynamicArray(10);
        dynamicArray.pushback(1);
        dynamicArray.pushback(2);
        dynamicArray.pushback(3);
        assertThat(dynamicArray.get(0)).isEqualTo(1);
        assertThat(dynamicArray.get(1)).isEqualTo(2);
        assertThat(dynamicArray.get(2)).isEqualTo(3);
    }

    @Test
    void shouldPopElementFromEndOfArray() {
        DynamicArray dynamicArray = new DynamicArray(10);
        dynamicArray.pushback(1);
        dynamicArray.pushback(2);
        dynamicArray.pushback(3);
        assertThat(dynamicArray.popback()).isEqualTo(3);
        assertThat(dynamicArray.popback()).isEqualTo(2);
        assertThat(dynamicArray.popback()).isEqualTo(1);
    }

    @Test
    void shouldDoubleCapacityOfArrayAsNeeded() {
        DynamicArray dynamicArray = new DynamicArray(2);
        assertThat(dynamicArray.getCapacity()).isEqualTo(2);
        dynamicArray.pushback(1);
        dynamicArray.pushback(2);
        dynamicArray.pushback(3);
        assertThat(dynamicArray.getCapacity()).isEqualTo(4);
    }

    @Test
    void shouldReturnCorrectSizeOfArray() {
        DynamicArray dynamicArray = new DynamicArray(10);
        assertThat(dynamicArray.getSize()).isEqualTo(0);
        dynamicArray.pushback(1);
        dynamicArray.pushback(2);
        dynamicArray.pushback(3);
        assertThat(dynamicArray.getSize()).isEqualTo(3);
    }
}