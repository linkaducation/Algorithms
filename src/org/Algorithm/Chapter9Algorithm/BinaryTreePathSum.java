package org.Algorithm.Chapter9Algorithm;

import org.Algorithm.SwordForOffer.HelperClass.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Ellen on 2017/5/27. 给定一个二叉树，找出所有路径中各节点相加总和等于给定 目标值 的路径。 一个有效的路径，指的是从根节点到叶节点的路径。
 */
public class BinaryTreePathSum {
	List<List<Integer>> result = new ArrayList<>();

	public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
		// Write your code here
		int temp = 0;
		if (root == null) {
			return result;
		}
		ArrayList<Integer> list = new ArrayList<>();
		findPath(root, list, 0, target);
		int len = result.size() - 1;
		for (int i = len; i >= 0;) {
			result.remove(i);
			i = i - 2;
		}
		return result;
	}

	private void findPath(TreeNode root, ArrayList<Integer> list, int count, int target) {
		ArrayList<Integer> temp = new ArrayList<>(list);
		int count1 = count;
		if (root == null) {
			if (count == target) {
				result.add(temp);
				return;
			}
			return;
		}
		count1 = count1 + root.val;
		temp.add(root.val);
		findPath(root.left, temp, count1, target);
		findPath(root.right, temp, count1, target);
	}

	public static void main(String[] args) {
		BinaryTreePathSum btp = new BinaryTreePathSum();
		TreeNode root = new TreeNode(1);
		TreeNode root1 = new TreeNode(2);
		TreeNode root2 = new TreeNode(2);
		TreeNode root3 = new TreeNode(3);
		TreeNode root4 = new TreeNode(4);
		root.left = root1;
		root.right = root4;
		root1.left = root2;
		root1.right = root3;
		List<List<Integer>> list = btp.binaryTreePathSum(root, 5);
		for (List<Integer> integers : list) {
			System.out.println(integers);
		}
	}

}
