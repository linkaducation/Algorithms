package org.Algorithm.Chapter9Algorithm;

import org.Algorithm.SwordForOffer.HelperClass.TreeNode;

/**
 * Created by Ellen on 2017/5/28. 找出二叉树最小深度
 */
public class MinDepth {
	public int minDepth(TreeNode root) {
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
		int left = Integer.MAX_VALUE;
		int right = Integer.MAX_VALUE;
		if (root.left != null) {
			left = getDeep(root.left);
		}
		if (root.right != null) {
			right = getDeep(root.right);
		}
		int minDeep = 0;
		if (root.right != null || root.left != null) {
			minDeep = Math.min(left, right);
		}
		return minDeep + 1;
	}

}
