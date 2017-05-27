package org.Algorithm.SwordForOffer;

import org.Algorithm.SwordForOffer.HelperClass.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Ellen on 2017/5/10. 从上往下打印出二叉树的每个节点，同层节点从左至右打印
 */
public class PrintFromTopToBottom {
	// ArrayList<Integer> list = new ArrayList<>();
	// ArrayList<TreeNode> helpList = new ArrayList<>();
	//
	// public ArrayList<Integer> printFromTopToBottom(TreeNode root) {
	// if (root != null) {
	// helpList.add(root);
	// }
	// while (!helpList.isEmpty()) {
	// list.add(helpList.get(0).val);
	// if (helpList.get(0).left != null) {
	// helpList.add(helpList.get(0).left);
	// }
	// if (helpList.get(0).right != null) {
	// helpList.add(helpList.get(0).right);
	// }
	// helpList.remove(0);
	// }
	// return list;
	// }
	public ArrayList<ArrayList<Integer>> printFromTopToBottom(TreeNode root) {
		if (root == null) {
			return new ArrayList<ArrayList<Integer>>();
		}
		Queue<TreeNode> queue = new LinkedList<>();
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			ArrayList<Integer> list = new ArrayList<>();
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				list.add(node.val);
				if (node.left != null) {
					queue.offer(node.left);
				}
				if (node.right != null) {
					queue.offer(node.right);
				}
			}
			result.add(list);
		}
		return result;
	}
}
