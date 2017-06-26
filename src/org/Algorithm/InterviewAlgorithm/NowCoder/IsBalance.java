package org.Algorithm.InterviewAlgorithm.NowCoder;

import org.Algorithm.SwordForOffer.HelperClass.TreeNode;

/**
 * Created by Ellen on 2017/6/26.
 */
public class IsBalance {
	public boolean isBalance(TreeNode root) {
		// write code here
	}

	private boolean isBalancee(TreeNode node) {
		if (node == null) {
			return true;
		}
		int left = isBalancee(node.left);
		int right = isBalancee(node.right);
		if (Math.abs(left - right) > 1) {

		}
	}
}
