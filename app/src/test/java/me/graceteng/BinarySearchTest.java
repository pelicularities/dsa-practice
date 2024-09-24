package me.graceteng;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class BinarySearchTest {
    @Test
    @SneakyThrows
    void shouldReturnIndexOfTargetValueGivenCommonCase() {
        BinarySearch binarySearch = new BinarySearch(new int[]{1, 3, 5, 7, 10}, 3);
        assertThat(binarySearch.findSolution()).isEqualTo(1);
        assertThat(binarySearch.getIterations()).isEqualTo(3);
    }

    @Test
    @SneakyThrows
    void shouldReturnIndexOfTargetValueGivenTargetInMiddle() {
        BinarySearch binarySearch = new BinarySearch(new int[]{1, 3, 5, 7, 10}, 5);
        assertThat(binarySearch.findSolution()).isEqualTo(2);
        assertThat(binarySearch.getIterations()).isEqualTo(1);
    }

    @Test
    @SneakyThrows
    void shouldReturnIndexOfTargetValueGivenTargetAtEnd() {
        BinarySearch binarySearch = new BinarySearch(new int[]{1, 3, 5, 7, 10}, 10);
        assertThat(binarySearch.findSolution()).isEqualTo(4);
        assertThat(binarySearch.getIterations()).isEqualTo(3);
    }

    @Test
    @SneakyThrows
    void shouldReturnIndexOfTargetValueGivenEvenNumberOfElements() {
        BinarySearch binarySearch = new BinarySearch(new int[]{1, 3, 5, 7, 10, 11}, 10);
        assertThat(binarySearch.findSolution()).isEqualTo(4);
        assertThat(binarySearch.getIterations()).isEqualTo(2);
    }

    @Test
    void shouldThrowExceptionGivenTargetValueNotFound() {
        BinarySearch binarySearch = new BinarySearch(new int[]{1, 3, 5, 7, 10, 11}, 6);
        assertThatException().isThrownBy(binarySearch::findSolution)
                .withMessage("Target value not found");
    }
}