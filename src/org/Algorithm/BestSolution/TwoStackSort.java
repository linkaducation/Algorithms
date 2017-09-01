package org.Algorithm.BestSolution;

import java.util.PriorityQueue;
import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Ellen on 2017/8/31.
 *
 * 两个栈实现排序
 */
public class TwoStackSort {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(2);
        stack.push(8);
        stack.push(3);
        stack.push(9);
        Stack<Integer> help = new Stack<>();
        int cur;
        while (!stack.isEmpty()) {
            cur = stack.pop();
            while (!help.isEmpty() && cur > help.peek()) {
                stack.push(help.pop());
            }
            help.push(cur);
        }
        while (!help.isEmpty()) {
            System.out.print(help.pop() + " ");
        }
    }
}
