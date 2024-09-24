package me.graceteng;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class TwoSumTest {
    public static Stream<Arguments> provideTestValuesForTwoSum() {
        return Stream.of(
                Arguments.of(new int[]{2, 7, 11, 15}, 9, 0, 1),
                Arguments.of(new int[]{3, 2, 4}, 6, 1, 2),
                Arguments.of(new int[]{3, 3}, 6, 0, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestValuesForTwoSum")
    void shouldReturnIndicesOfValuesTotallingTarget(int[] numbers, int target, int i, int j) {
        TwoSum test = new TwoSum(numbers, target);

        assertThat(test.getSolution()[0]).isEqualTo(i);
        assertThat(test.getSolution()[1]).isEqualTo(j);
    }

    @Test
    void shouldReturnEmptyArrayIfNoMatchFound() {
        TwoSum noMatchFound = new TwoSum(new int[]{2, 7, 11, 15}, 10);
        assertThat(noMatchFound.getSolution()).isEmpty();
    }
}