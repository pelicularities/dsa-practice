package me.graceteng.neetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidParentheses {
    static boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (currentChar == '('
                || currentChar == '['
                || currentChar == '{') {
                // push open parens on stack
                stack.push(currentChar);
                continue;
            }
            // since the current char is a closing parens,
            // check if the stack is empty
            if (stack.isEmpty()) {
                return false;
            }

            // pop closing parens off the stack
            // and make sure it matches
            if (currentChar == ')') {
                Character pop = stack.pop();
                if (!pop.equals('(')) {
                    return false;
                }
            }
            if (currentChar == '}') {
                Character pop = stack.pop();
                if (!pop.equals('{')) {
                    return false;
                }
            }
            if (currentChar == ']') {
                Character pop = stack.pop();
                if (!pop.equals('[')) {
                    return false;
                }
            }
        }
        // if stack is not empty,
        // there was an unclosed parens
        return stack.isEmpty();
    }
}
