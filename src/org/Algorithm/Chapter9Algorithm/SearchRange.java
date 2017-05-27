package org.Algorithm.Chapter9Algorithm;

import org.Algorithm.SwordForOffer.HelperClass.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/**
 * Created by Ellen on 2017/5/27. 给定两个值 k1 和 k2（k1 < k2）和一个二叉查找树的根节点。找到树中所有值在 k1 到 k2 范围内的节点。即打印所有x (k1 <= x <= k2) 其中 x
 * 是二叉查找树的中的节点值。返回所有升序的节点值。
 */
public class SearchRange {

	public ArrayList<Integer> searchRange(TreeNode root, int k1, int k2) {
		// write your code here
		HashSet<Integer> result = new HashSet<>();
		helper(result, root, k1, k2);
		ArrayList<Integer> list = new ArrayList<>(result);
		Collections.sort(list);
		return list;
	}

	private HashSet<Integer> helper(HashSet<Integer> array, TreeNode root, int k1, int k2) {
		if (root == null) {
			return new HashSet<>();
		}
		HashSet<Integer> left = new HashSet<>();
		HashSet<Integer> right = new HashSet<>();
		if (root.val > k1) {
			left = helper(array, root.left, k1, k2);
		}
		if (root.val < k2) {
			right = helper(array, root.right, k1, k2);
		}
		if (root.val >= k1 && root.val <= k2) {
			array.add(root.val);
		}
		array.addAll(left);
		array.addAll(right);
		return array;
	}
}
