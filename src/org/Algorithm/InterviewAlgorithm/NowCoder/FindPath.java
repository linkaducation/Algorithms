package org.Algorithm.InterviewAlgorithm.NowCoder;

import org.Algorithm.SwordForOffer.HelperClass.TreeNode;

import java.util.ArrayList;

/**
 * Created by Ellen on 2017/6/26.
 * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径
 */
public class FindPath {

	private ArrayList<ArrayList<Integer>> res = new ArrayList<>();

	public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
		countSum(root, 0, target, new ArrayList<Integer>());
		return res;
	}

	private void countSum(TreeNode node, int sum, int target, ArrayList<Integer> list) {
		if (node == null) {
			return;
		}
		sum += node.val;
		list.add(node.val);
		if ((node.left == null && node.right == null) || sum > target) {
			if (sum == target) {
				res.add(list);
			}
			return;
		}
		countSum(node.left, sum, target, new ArrayList<>(list));
		countSum(node.right, sum, target, new ArrayList<>(list));
	}
}
