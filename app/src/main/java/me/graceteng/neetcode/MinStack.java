package me.graceteng.neetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinStack {
    Deque<Integer> stack = new ArrayDeque<>();
    Deque<Integer> minStack = new ArrayDeque<>();

    public MinStack() {}

    public void push(int val) {
        stack.push(val);

        // if minStack is empty, val is guaranteed to be minimum
        if (minStack.isEmpty()) {
            minStack.push(val);
        } else if (minStack.peek() >= val) {
            // if val is current smallest value,
            // replace existing minimum
            minStack.push(val);
        }
    }

    public void pop() {
        // guaranteed to be non-empty
        Integer val = stack.pop();
        if (!minStack.isEmpty() && minStack.peek().equals(val)) {
            minStack.pop();
        }
    }

    public int top() {
        // guaranteed to be non-empty, so no NPE
        return stack.peek();
    }

    public int getMin() {
        // guaranteed to be non-empty, so no NPE
        return minStack.peek();
    }
}
