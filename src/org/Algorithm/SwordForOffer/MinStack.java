package org.Algorithm.SwordForOffer;

import java.util.Stack;

/**
 * Created by Ellen on 2017/5/9.
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数
 */
public class MinStack {
    Stack<Integer> minStack = new Stack<>();
    Stack<Integer> helpStack = new Stack<>();
    Integer temp = null;

    public void push(int node) {
        if (minStack.isEmpty()) {
           minStack.push(node);
           helpStack.push(node);
           temp = node;
        }else if (node > temp){
            minStack.push(temp);
            helpStack.push(node);
        }else {
            minStack.push(node);
            helpStack.push(node);
            temp = node;
        }
    }

    public void pop() {
        helpStack.pop();
        minStack.pop();
    }

    public int top() {
        int temp = helpStack.pop();
        helpStack.push(temp);
        return temp;
    }

    public int min() {
        int temp = minStack.pop();
        minStack.push(temp);
        return temp;
    }

    public static void main(String[] args) {
        MinStack ms = new MinStack();
        ms.push(3);
        ms.push(4);
        ms.push(5);
        ms.push(2);
        ms.push(1);
        ms.push(0);
        ms.pop();
        System.out.println(ms.minStack);
    }
}
