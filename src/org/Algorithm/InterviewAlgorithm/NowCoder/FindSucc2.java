package org.Algorithm.InterviewAlgorithm.NowCoder;

import org.Algorithm.SwordForOffer.HelperClass.TreeNode;

import java.util.Stack;

/**
 * Created by Ellen on 2017/6/26.
 * 请设计一个算法，寻找排序二叉树中指定结点的下一个结点（即中序遍历的后继）
 */
public class FindSucc2 {

	public int findSucc(TreeNode root, int p) {
		// write code here
		boolean flag = false;
		Stack<TreeNode> stack = new Stack<>();
		while (!stack.isEmpty() || root != null) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			TreeNode node = stack.pop();
			if (flag) {
				return node.val;
			}
			if (node.val == p) {
				flag = true;
			}
			root = node.right;
		}
		return 0;
	}
}
