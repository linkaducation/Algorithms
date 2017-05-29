package org.Algorithm.Chapter9Algorithm;

import org.Algorithm.SwordForOffer.HelperClass.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Ellen on 2017/5/29. 给出一棵二叉树，返回其节点值从底向上的层次序遍历（按从叶节点所在层到根节点所在的层遍历，然后逐层从左往右遍历）
 */
public class LevelOrderBottom {
	public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
		// write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        order(result,queue);
        return result;
	}

	private void order(ArrayList<ArrayList<Integer>> result, LinkedList<TreeNode> queueList) {
        if (queueList.isEmpty()) {
            return;
        }
        ArrayList<Integer> list = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
	    while (!queueList.isEmpty()) {
	        TreeNode node = queueList.poll();
	        list.add(node.val);
	        if (node.left!=null) {
	            queue.offer(node.left);
            }
            if (node.right != null) {
	            queue.offer(node.right);
            }
        }
        order(result,queue);
	    result.add(list);
	}
}
