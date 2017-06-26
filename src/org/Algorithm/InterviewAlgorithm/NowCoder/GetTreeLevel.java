package org.Algorithm.InterviewAlgorithm.NowCoder;

import org.Algorithm.SwordForOffer.HelperClass.ListNode;
import org.Algorithm.SwordForOffer.HelperClass.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Ellen on 2017/6/26.
 * 对于一棵二叉树，请设计一个算法，创建含有某一深度上所有结点的链表
 */
public class GetTreeLevel {
	public ListNode getTreeLevel(TreeNode root, int dep) {
		// write code here
		Queue<TreeNode> queue1 = new LinkedList<>();
		Queue<TreeNode> queue2 = new LinkedList<>();
		queue1.offer(root);
		int f = 1;
		while (f < dep) {
			if (f % 2 == 1) {
				while (!queue1.isEmpty()) {
					TreeNode node = queue1.poll();
					queue2.offer(node.left);
					queue2.offer(node.right);
				}
				f++;
			} else {
				while (!queue2.isEmpty()) {
					TreeNode node = queue2.poll();
					queue1.offer(node.left);
					queue1.offer(node.right);
				}
				f++;
			}
		}
		ListNode head = new ListNode(0);
		ListNode dummy = head;
		while (!queue1.isEmpty()) {
			ListNode node = new ListNode(queue1.poll().val);
			dummy.next = node;
			dummy = dummy.next;
		}
		while (!queue2.isEmpty()) {
			ListNode node = new ListNode(queue2.poll().val);
			dummy.next = node;
			dummy = dummy.next;
		}
		return head.next;
	}
}
