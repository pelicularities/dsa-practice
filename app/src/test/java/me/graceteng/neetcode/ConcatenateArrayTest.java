package me.graceteng.neetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ConcatenateArrayTest {
    public static Stream<Arguments> provideArgsForConcatenateArrayTest() {
        return Stream.of(
                Arguments.of(new int[]{1, 4, 1, 2}, new int[]{1, 4, 1, 2, 1, 4, 1, 2}),
                Arguments.of(new int[]{22,21,20,1}, new int[]{22,21,20,1,22,21,20,1})
        );
    }

    @ParameterizedTest
    @MethodSource("provideArgsForConcatenateArrayTest")
    void shouldCorrectlyReturnConcatenatedArray(int[] input, int[] expected) {
        int[] result = ConcatenateArray.getConcatenation(input);
        assertThat(result.length).isEqualTo(expected.length);
        for (int i = 0; i < result.length; i++) {
            assertThat(result[i]).isEqualTo(expected[i]);
        }
    }
}