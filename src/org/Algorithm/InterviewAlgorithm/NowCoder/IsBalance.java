package org.Algorithm.InterviewAlgorithm.NowCoder;

import org.Algorithm.SwordForOffer.HelperClass.TreeNode;

/**
 * Created by Ellen on 2017/6/26.
 */
public class IsBalance {
	public boolean isBalance(TreeNode root) {
		// write code here
		int left = isBalancee(root.left);
		int right = isBalancee(root.right);
		if (Math.abs(left - right) > 1) {
			return false;
		} else {
			return true;
		}
	}

	private int isBalancee(TreeNode node) {
		if (node == null) {
			return 0;
		}
		int left = isBalancee(node.left);
		int right = isBalancee(node.right);
		if (Math.abs(left - right) > 1) {
			return -Integer.MAX_VALUE;
		} else {
			return Math.max(left, right) + 1;
		}
	}
}
