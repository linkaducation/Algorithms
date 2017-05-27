package org.Algorithm.Chapter9Algorithm;

import org.Algorithm.SwordForOffer.HelperClass.TreeNode;

/**
 * Created by Ellen on 2017/5/27. 给出一棵二叉树，寻找一条路径使其路径和最大，路径可以在任一节点中开始和结束（路径和为两个节点之间所在路径上的节点权值之和）
 */
public class MaxPathSum {
	public class resultType {
		int singlePath, maxPath;
		resultType(int singlePath, int maxPath) {
			this.singlePath = singlePath;
			this.maxPath = maxPath;
		}
	}

	public int maxPathSum(TreeNode root) {
		// write your code here
        resultType resultType = helper(root);
        return resultType.maxPath;
    }

	private resultType helper(TreeNode root) {
		if (root == null) {
			return new resultType(0, Integer.MIN_VALUE);
		}
		// Divied
		resultType left = helper(root.left);
		resultType right = helper(root.right);

		// Conquer
		int singlePath = Math.max(left.singlePath, right.singlePath) + root.val;
		singlePath = Math.max(singlePath, 0);

		int maxPath = Math.max(left.maxPath, right.maxPath);
		maxPath = Math.max(maxPath, left.singlePath + right.singlePath + root.val);

		return new resultType(singlePath,maxPath);
	}
}
