package org.Algorithm.Chapter9Algorithm;

import java.util.Stack;

/**
 * Created by Ellen on 2017/6/16.
 * 给定一个字符串所表示的括号序列，包含以下字符： '(', ')', '{', '}', '[' and ']'，
 * 判定是否是有效的括号序列
 */
public class IsValidParentheses {
    public boolean isValidParentheses(String s) {
        // Write your code here
        if (s.length() % 2 != 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if ("({[".contains(String.valueOf(c))) {
                stack.push(c);
            } else {
                if (!stack.isEmpty() && isDouble(stack.peek(), c)) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private boolean isDouble(char a, char b) {
        if ((a == '(' && b == ')') || (a == '{' && b == '}') || (a == '[' && b == ']')) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        IsValidParentheses vp = new IsValidParentheses();
        boolean i = vp.isValidParentheses("()[]");
        System.out.println(i);
    }
}
