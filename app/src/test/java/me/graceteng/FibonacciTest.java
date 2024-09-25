package me.graceteng;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FibonacciTest {
    @Test
    void shouldReturnFirstFibonacciNumber() {
        assertThat(Fibonacci.generateNumber(1)).isEqualTo(1);
    }

    @Test
    void shouldReturnSecondFibonacciNumber() {
        assertThat(Fibonacci.generateNumber(2)).isEqualTo(1);
    }

    @Test
    void shouldReturnThirdFibonacciNumber() {
        assertThat(Fibonacci.generateNumber(3)).isEqualTo(2);
    }

    @Test
    void shouldReturnNthFibonacciNumber() {
        assertThat(Fibonacci.generateNumber(10)).isEqualTo(55);
    }
}