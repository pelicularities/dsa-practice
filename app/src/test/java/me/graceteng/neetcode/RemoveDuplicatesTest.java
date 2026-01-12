package me.graceteng.neetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class RemoveDuplicatesTest {
    public static Stream<Arguments> provideArraysForRemoveDuplicatesTest() {
        return Stream.of(
                Arguments.of(new int[]{1, 1, 2, 3, 4}, new int[]{1, 2, 3, 4}),
                Arguments.of(new int[]{2, 10, 10, 30, 30, 30}, new int[]{2, 10, 30}),
                Arguments.of(new int[]{99}, new int[]{99})
        );
    }

    @ParameterizedTest
    @MethodSource("provideArraysForRemoveDuplicatesTest")
    void shouldCorrectlyReturnNumberOfUniqueValuesInStaticArray(int[] input, int[] expected) {
        int result = RemoveDuplicates.removeDuplicates(input);
        assertThat(result).isEqualTo(expected.length);
        for (int i = 0; i < result; i++) {
            assertThat(input[i]).isEqualTo(expected[i]);
        }
    }
}