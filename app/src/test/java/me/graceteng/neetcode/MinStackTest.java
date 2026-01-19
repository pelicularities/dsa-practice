package me.graceteng.neetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MinStackTest {
    @Test
    void test1() {
        MinStack minStack = new MinStack();
        minStack.push(1);
        minStack.push(2);
        minStack.push(0);
        assertThat(minStack.getMin()).isEqualTo(0);
        minStack.pop();
        assertThat(minStack.top()).isEqualTo(2);
        assertThat(minStack.getMin()).isEqualTo(1);
    }

    @Test
    void test2() {
        MinStack minStack = new MinStack();
        minStack.push(-1);
        minStack.push(5);
        minStack.push(0);
        minStack.push(-5);
        assertThat(minStack.getMin()).isEqualTo(-5);
        minStack.pop();
        assertThat(minStack.getMin()).isEqualTo(-1);
        minStack.pop();
        assertThat(minStack.getMin()).isEqualTo(-1);
        minStack.pop();
        assertThat(minStack.getMin()).isEqualTo(-1);
        minStack.pop();
        minStack.push(4);
        minStack.push(-4);
        minStack.push(2);
        assertThat(minStack.getMin()).isEqualTo(-4);
        minStack.pop();
        assertThat(minStack.getMin()).isEqualTo(-4);
        minStack.pop();
        assertThat(minStack.getMin()).isEqualTo(4);
    }
}