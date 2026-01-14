package me.graceteng.neetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ValidParenthesesTest {
    public static Stream<Arguments> provideArgsForValidParenthesesTest() {
        return Stream.of(
                Arguments.of("[]", true),
                Arguments.of("([{}])", true),
                Arguments.of("[(])", false),
                Arguments.of("]", false)
        );
    }

    @ParameterizedTest
    @MethodSource("provideArgsForValidParenthesesTest")
    void shouldIdentifyIfStringHasValidParentheses(String input, boolean expected) {
        assertThat(ValidParentheses.isValid(input)).isEqualTo(expected);
    }
}