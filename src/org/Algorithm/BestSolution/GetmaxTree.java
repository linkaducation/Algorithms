package org.Algorithm.BestSolution;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Ellen on 2017/9/1.
 *
 *
 */
public class GetmaxTree {
    static class Node {
        Node left;
        Node right;
        int value;

        Node(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            Node[] nodes = new Node[n];
            for (int i = 0; i < n; i++) {
                nodes[i] = new Node(sc.nextInt());
            }
            Map<Node, Node> lmap = new HashMap<>();
            Map<Node, Node> rmap = new HashMap<>();
            Stack<Node> stack = new Stack<>();
            for (int i = 0; i < n; i++) {
                Node cur = nodes[i];
                while (!stack.isEmpty() && stack.peek().value < cur.value) {
                    swich(stack, lmap);
                }
                stack.push(cur);
            }
            while (!stack.isEmpty()) {
                swich(stack, lmap);
            }
            stack.clear();
            for (int i = n - 1; i >= 0; i--) {
                Node cur = nodes[i];
                while (!stack.isEmpty() && stack.peek().value < cur.value) {
                    swich(stack, rmap);
                }
                stack.push(cur);
            }
            while (!stack.isEmpty()) {
                swich(stack, rmap);
            }
            Node head = null;
            for (int i = 0; i < n; i++) {
                Node node = nodes[i];
                Node lNode = lmap.get(node);
                Node rNode = rmap.get(node);
                if (lNode == null && rNode == null) {
                    head = node;
                } else if (lNode == null) {
                    if (rNode.left == null) {
                        rNode.left = node;
                    } else {
                        rNode.right = node;
                    }
                } else if (rNode == null){
                    if (lNode.left == null) {
                        lNode.left = node;
                    } else {
                        lNode.right = node;
                    }
                } else {
                    Node parent = lNode.value < rNode.value ? lNode : rNode;
                    if (parent.left == null) {
                        parent.left = node;
                    } else {
                        parent.right = node;
                    }
                }
            }
            System.out.println(head);
        }
    }

    private static void swich(Stack<Node> stack, Map<Node, Node> map) {
        Node node = stack.pop();
        if (stack.isEmpty()) {
            map.put(node, null);
        } else {
            map.put(node, stack.peek());
        }
    }

}
