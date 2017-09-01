package org.Algorithm.BestSolution;

import java.util.Stack;

/**
 * Created by Ellen on 2017/8/31.
 * 不借助任何空间实现一个栈的逆序
 */
public class ReverseStack {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(4);
        stack.push(3);
        stack.push(2);
        stack.push(1);
        reverse(stack);
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        System.out.println(sb.toString());
    }

    /**
     * 每调用一次getAndRemoveLast,获取到栈底值，当栈为空回时，再依次压入弹出来的元素，实现了反序
     *
     * @param stack
     */
    private static void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int result = getAndRemoveLast(stack);
        reverse(stack);
        stack.push(result);
    }

    /**
     * 不断的取栈下面的值，直到栈为空，返回栈底元素，再逐个压入之前被取出的元素
     *
     * @param stack
     * @return
     */
    private static int getAndRemoveLast(Stack<Integer> stack) {
        int result = stack.pop();
        if (stack.isEmpty()) {
            return result;
        }
        int last = getAndRemoveLast(stack);
        stack.push(result);
        return last;
    }
}
