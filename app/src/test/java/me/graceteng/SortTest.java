package me.graceteng;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SortTest {
    @Nested
    class isSorted {
        @Test
        void shouldReturnTrueIfNumbersAreSorted() {
            assertThat(Sort.isSorted(new int[]{-1, 0, 1})).isTrue();
        }

        @Test
        void shouldReturnFalseIfNumbersAreNotSorted() {
            assertThat(Sort.isSorted(new int[]{0, -1, 2})).isFalse();
        }
    }

    @Test
    void shouldBubbleSortNumbers() {
        assertThat(Sort.bubbleSort(new int[]{3, -1, 6, -4, 5, 3, 0, 7}))
                .isEqualTo(new int[]{-4, -1, 0, 3, 3, 5, 6, 7});
    }

    @Test
    void shouldInsertionSortNumbers() {
        assertThat(Sort.insertionSort(new int[]{3, -1, 6, -4, 5, 3, 0, 7}))
                .isEqualTo(new int[]{-4, -1, 0, 3, 3, 5, 6, 7});
    }
}