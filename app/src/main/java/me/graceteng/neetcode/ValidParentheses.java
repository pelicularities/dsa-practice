package me.graceteng.neetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidParentheses {
    static boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char currentParens = s.charAt(i);
            // check for open parens
            if (isOpen(currentParens)) {
                // push open parens on stack
                stack.push(currentParens);
                continue;
            }

            // since the current char is a closing parens,
            // check if the stack is empty
            if (stack.isEmpty()) {
                return false;
            }

            // pop open parens off the stack
            // and make sure it matches
            Character lastParens = stack.pop();
            if (lastParens != getMatchingOpenParens(currentParens)) {
                return false;
            }
        }
        // if stack is not empty,
        // there was an unclosed parens
        return stack.isEmpty();
    }

    static boolean isOpen(char c) {
        return (c == '(' || c == '[' || c == '{');
    }

    static char getMatchingOpenParens(char closingParens) {
        return switch (closingParens) {
            case ')' -> '(';
            case ']' -> '[';
            case '}' -> '{';
            default -> throw new IllegalArgumentException("Argument must be one of ')', ']' or '}'");
        };
    }
}
