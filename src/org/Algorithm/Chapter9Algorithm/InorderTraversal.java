package org.Algorithm.Chapter9Algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.Algorithm.SwordForOffer.HelperClass.TreeNode;

/**
 * Created by Ellen on 2017/5/27. 二叉树中序遍历
 */
public class InorderTraversal {
	// 递归版本
	ArrayList<Integer> list = new ArrayList<>();
	public List inorderTraversal(TreeNode root) {
		if (root == null) {
			return null;
		}
		reverse(root);
		return list;
	}

	public void reverse(TreeNode node) {
		if (node == null) {
			return;
		}
		reverse(node.left);
		list.add(node.val);
		reverse(node.right);
	}



	//非递归版本
    public List pre(TreeNode root) {
		if (root == null) {
			return null;
		}
		Stack<TreeNode> stack = new Stack<>();
		ArrayList<Integer> result = new ArrayList<>();
		TreeNode curt = root;
		while (curt != null || !stack.isEmpty()) {
			while (curt != null) {
				stack.push(curt);
				curt = curt.left;
			}
			curt = stack.pop();
			result.add(curt.val);
			curt = curt.right;
		}
		return result;
    }
}
