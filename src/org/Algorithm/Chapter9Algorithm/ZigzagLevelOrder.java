package org.Algorithm.Chapter9Algorithm;

import org.Algorithm.SwordForOffer.HelperClass.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by Ellen on 2017/5/29.
 * 给出一棵二叉树，返回其节点值的锯齿形层次遍历（先从左往右，下一层再从右往左，层与层之间交替进行）
 * 思路，一排用栈，一排用队列，交替
 */
public class ZigzagLevelOrder {
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        // write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> stack1 = new Stack<>();
        boolean flag = true;     //为true是弹出栈，为false时弹出队列
        stack.push(root);
        while (!stack.isEmpty() || !stack1.isEmpty()) {
            if (flag) {
                ArrayList<Integer> list = new ArrayList<>();
                while (!stack.isEmpty()) {
                    TreeNode node = stack.pop();
                    list.add(node.val);
                    if (node.left != null) {
                        stack1.push(node.left);
                    }
                    if (node.right != null) {
                        stack1.push(node.right);
                    }
                }
                result.add(list);
                flag = false;
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                while (!stack1.isEmpty()) {
                    TreeNode node = stack1.pop();
                    list.add(node.val);
                    if (node.right != null) {
                        stack.push(node.right);
                    }
                    if (node.left != null) {
                        stack.push(node.left);
                    }
                }
                result.add(list);
                flag = true;
            }
        }
        return result;
    }
}
