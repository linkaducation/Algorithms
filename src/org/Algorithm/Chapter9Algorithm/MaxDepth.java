package org.Algorithm.Chapter9Algorithm;

import org.Algorithm.SwordForOffer.HelperClass.TreeNode;

/**
 * Created by Ellen on 2017/5/28. 找出二叉树最小深度
 */
public class MaxDepth {
	public int maxDepth(TreeNode root) {
		// write your code here
		if (root == null) {
			return 0;
		}
		if (root.left == null && root.right == null) {
			return 1;
		}
		return getDeep(root);
	}

	private int getDeep(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = Integer.MIN_VALUE;
		int right = Integer.MIN_VALUE;
		if (root.left != null) {
			left = getDeep(root.left);
		}
		if (root.right != null) {
			right = getDeep(root.right);
		}
		int minDeep = 0;
		if (root.right != null || root.left != null) {
			minDeep = Math.max(left, right);
		}
		return minDeep + 1;
	}

}
