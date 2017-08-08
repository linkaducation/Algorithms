package org.Algorithm.InterviewAlgorithm.NowCoder;

import org.Algorithm.SwordForOffer.HelperClass.ListNode;
import org.Algorithm.SwordForOffer.HelperClass.TreeNode;

import java.util.Stack;

/**
 * Created by Ellen on 2017/8/8.
 * 有一个类似结点的数据结构TreeNode，包含了val属性和指向其它结点的指针。
 * 其可以用来表示二叉查找树(其中left指针表示左儿子，right指针表示右儿子)。
 * 请编写一个方法，将二叉查找树转换为一个链表，其中二叉查找树的数据结构用TreeNode实现，链表的数据结构用ListNode实现。
 * 给定二叉查找树的根结点指针root，请返回转换成的链表的头指针
 * <p>
 * 中序遍历转换为链表
 */
public class TreeToList {
	public ListNode treeToList(TreeNode root) {
		// write code here
		ListNode dummyNode = new ListNode(0);
		ListNode head = dummyNode;
		Stack<TreeNode> stack = new Stack<>();
		while (root != null || !stack.isEmpty()) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			TreeNode node = stack.pop();
			ListNode lNode = new ListNode(node.val);
			head.next = lNode;
			head = lNode;
			root = node.right;
		}
		return dummyNode.next;
	}

}
