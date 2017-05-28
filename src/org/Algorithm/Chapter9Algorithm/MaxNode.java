package org.Algorithm.Chapter9Algorithm;

import org.Algorithm.SwordForOffer.HelperClass.TreeNode;

import java.util.Stack;

/**
 * Created by Ellen on 2017/5/28. 在二叉树中寻找值最大的节点并返回。
 */
public class MaxNode {
    TreeNode min = new TreeNode(Integer.MIN_VALUE);
	public TreeNode maxNode(TreeNode root) {
		// Write your code here
        if (root == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode tempNode = root;
        while (tempNode != null || !stack.isEmpty()) {
            while (tempNode != null) {
                stack.push(tempNode);
                tempNode = tempNode.left;
            }
            tempNode = stack.pop();
            min = min.val < tempNode.val ? tempNode : min;
            tempNode = tempNode.right;
        }
        return min;
	}
}
