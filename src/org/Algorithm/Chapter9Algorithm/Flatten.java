package org.Algorithm.Chapter9Algorithm;

import org.Algorithm.SwordForOffer.HelperClass.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by Ellen on 2017/5/28. 将一棵二叉树按照前序遍历拆解成为一个假链表。所谓的假链表是说，用二叉树的 right 指针，来表示链表中的 next 指针。
 * 思路：前序遍历，构建一个书
 */
public class Flatten {
	public void flatten(TreeNode root) {
		// write your code here
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack();
        TreeNode curt = null;
        stack.push(root);
        Queue<TreeNode> queue = new LinkedList<>();
        while (!stack.isEmpty()) {
            curt = stack.pop();
            queue.offer(curt);
            if (curt.right != null) {
                stack.push(curt.right);
            }
            if (curt.left != null) {
                stack.push(curt.left);
            }
        }
        curt = root;
        queue.poll();
        while (!queue.isEmpty()) {
            curt.right = queue.poll();
            curt.left = null;
            curt = curt.right;
        }
	}

}
