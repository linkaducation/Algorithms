package org.Algorithm.Chapter9Algorithm;

import org.Algorithm.SwordForOffer.HelperClass.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Ellen on 2017/5/28. 给一棵二叉树，找出从根节点到叶子节点的所有路径。 "1->2->5", "1->3"
 */
public class BinaryTreePaths {
	ArrayList<ArrayList<Integer>> result = new ArrayList<>();
	ArrayList<Integer> list = new ArrayList<>();

	public List<ArrayList<Integer>> binaryTreePaths(TreeNode root) {
		// Write your code here
		findPath(root, list);
		return result;
	}

	private void findPath(TreeNode node, ArrayList<Integer> array) {
		ArrayList<Integer> array1 = new ArrayList<>(array);
		if (node != null && node.right == null && node.left == null) {
			array1.add(node.val);
			result.add(array1);
			return;
		}
		array1.add(node.val);
		findPath(node.left, array1);
		findPath(node.right, array1);
	}

	public static void main(String[] args) {
		BinaryTreePaths btp = new BinaryTreePaths();
		TreeNode root = new TreeNode(1);
		TreeNode root1 = new TreeNode(2);
		TreeNode root2 = new TreeNode(2);
		TreeNode root3 = new TreeNode(3);
		TreeNode root4 = new TreeNode(4);
		root.left = root1;
		root.right = root4;
		root1.left = root2;
		root1.right = root3;
		List<ArrayList<Integer>> arrayLists = btp.binaryTreePaths(root);
		for (ArrayList<Integer> arrayList : arrayLists) {
			System.out.println(arrayList);
		}
	}
}
