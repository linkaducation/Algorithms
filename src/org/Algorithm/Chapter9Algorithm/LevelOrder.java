package org.Algorithm.Chapter9Algorithm;

import org.Algorithm.SwordForOffer.HelperClass.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by Ellen on 2017/5/29. 给出一棵二叉树，返回其节点值的层次遍历（逐层从左往右访问）
 */
public class LevelOrder {
	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
		// write your code here
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		if (root == null) {
		    return result;
        }
		LinkedList<TreeNode> list = new LinkedList<>();
		list.add(root);
		order(result,list);
		return result;
	}

	private void order(ArrayList<ArrayList<Integer>> result, LinkedList<TreeNode> list) {
	    if (list.isEmpty()) {
	        return;
        }
        ArrayList<Integer> nList = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        while (!list.isEmpty()) {
            TreeNode node = list.poll();
            nList.add(node.val);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        list = null;
        result.add(nList);
        order(result,queue);
	}
}
