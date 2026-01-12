package me.graceteng.neetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class RemoveElementTest {
    public static Stream<Arguments> provideArraysForRemoveElementsTest() {
        return Stream.of(
                Arguments.of(new int[]{1, 1, 2, 3, 4}, 1, new int[]{2, 3, 4}),
                Arguments.of(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2, new int[]{0, 1, 3, 0, 4}),
                Arguments.of(new int[]{}, 0, new int[]{}),
                Arguments.of(new int[]{1, 1, 1, 1, 1}, 1, new int[]{}),
                Arguments.of(new int[]{5, 1, 5, 2, 5, 3, 5}, 5, new int[]{1, 2, 3})
        );
    }

    @ParameterizedTest
    @MethodSource("provideArraysForRemoveElementsTest")
    void shouldCorrectlyReturnNumberOfOtherElementsInArray(int[] input, int element, int[] expected) {
        int result = RemoveElement.removeElement(input, element);
        assertThat(result).isEqualTo(expected.length);
        List<Integer> actualValues = new ArrayList<>();
        for (int i = 0; i < result; i++) {
            actualValues.add(input[i]);
        }
        assertThat(actualValues)
                .containsExactlyInAnyOrderElementsOf(
                        Arrays.stream(expected).boxed().toList());
    }
}