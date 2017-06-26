package org.Algorithm.InterviewAlgorithm.NowCoder;

import org.Algorithm.SwordForOffer.HelperClass.TreeNode;

import java.util.Stack;

/**
 * Created by Ellen on 2017/6/26.
 * 请设计一个算法，寻找排序二叉树中指定结点的下一个结点（即中序遍历的后继）
 */
public class FindSucc {

	public int findSucc(TreeNode root, int p) {
		// write code here
		Stack<TreeNode> stack = new Stack<>();
		while (root != null) {
			if (root.val == p) {
				if (root.right != null) {
					return root.right.val;
				}
				if (root.right == null) {
					return stack.pop().val;
				}
			} else if (root.val < p) {
				stack.push(root);
				root = root.right;
			} else if (root.val > p) {
				stack.push(root);
				root = root.left;
			}
		}
		return 0;
	}
}
