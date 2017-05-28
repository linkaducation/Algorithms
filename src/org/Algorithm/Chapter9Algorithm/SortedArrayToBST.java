package org.Algorithm.Chapter9Algorithm;

import org.Algorithm.SwordForOffer.HelperClass.TreeNode;

/**
 * Created by Ellen on 2017/5/28. 给一个排序数组（从小到大），将其转换为一棵高度最小的排序二叉树
 */
public class SortedArrayToBST {
	public TreeNode sortedArrayToBST(int[] A) {
		// write your code here
		if (A.length <= 0 || A == null) {
			return null;
		}
		return buildTree(A, 0, A.length - 1);
	}

	private TreeNode buildTree(int[] array, int start, int end) {
		if (start > end) {
			return null;
		}
		TreeNode node = new TreeNode(array[(start + end) / 2]);
		node.left = buildTree(array, start, (start + end) / 2 - 1);
		node.right = buildTree(array, (start + end) / 2 + 1, end);
		return node;
	}
}
